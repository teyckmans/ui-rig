package eu.rigeldev.uirig.demo

import eu.rigeldev.uirig.demo.state.LoggedInState
import eu.rigeldev.uirig.demo.state.LoggedInState.Companion.loggedInState
import eu.rigeldev.uirig.demo.state.NotLoggedInState
import eu.rigeldev.uirig.demo.state.NotLoggedInState.Companion.notLoggedInState
import eu.rigeldev.uirig.demo.state.PageName.*
import eu.rigeldev.uirig.demo.views.footer
import eu.rigeldev.uirig.demo.views.menu
import eu.rigeldev.uirig.UiRigApplication
import eu.rigeldev.uirig.core.UiAppControl
import eu.rigeldev.uirig.update.Update
import eu.rigeldev.uirig.view.DslDiv
import eu.rigeldev.uirig.view.DslElement
import eu.rigeldev.uirig.view.div

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
class DemoApp : UiRigApplication {

    override fun init(): Update {
        val initialState = notLoggedInState()
                .baseApiUrl("http://localhost:8080/api")
                .build()

        return Update(initialState)
    }

    override fun update(message: Any, state: Any): Update {

        return when (state) {
            is NotLoggedInState -> {
                notLoggedInUpdate(state, message)
            }
            is LoggedInState -> {
                loggedInUpdate(message, state)
            }
            else -> {
                Update(state)
            }
        }
    }

    private fun loggedInUpdate(message: Any, state: LoggedInState): Update {
        return when (message) {
            is ToPage -> {
                loggedInState(state)
                        .pageName(message.pageName)
                        .buildUpdate()
            }
            is Logout -> {
                notLoggedInState(state)
                        .warnings(listOf("You have been logged out, see you soon"))
                        .buildUpdate()
            }
            else -> {
                Update(state)
            }
        }
    }

    private fun notLoggedInUpdate(state: NotLoggedInState, message: Any): Update {
        val api = DemoApi(state.baseApiUrl)

        return when (message) {
            is UsernameEntered -> {
                notLoggedInState(state)
                        .username(message.username)
                        .buildUpdate()

            }
            is PasswordEntered -> {
                notLoggedInState(state)
                        .password(message.password)
                        .buildUpdate()
            }
            is Login -> {
                val warnings = ArrayList<String>()

                if (state.username == "") {
                    warnings.add("Username is required")
                }

                if (state.password == "") {
                    warnings.add("Password is required")
                }

                if (warnings.isEmpty()) {
                    notLoggedInState(state)
                            .buildUpdate(api.authenticate(state.username, state.password))
                } else {
                    notLoggedInState(state)
                            .warnings(warnings)
                            .buildUpdate()
                }
            }
            is LoginWorking -> {
                notLoggedInState(state)
                        .warnings(listOf("Logging in..."))
                        .buildUpdate()
            }
            is LoginResponse -> {
                if (message.success) {
                    loggedInState(state)
                            .roles(message.roles)
                            .buildUpdate()
                } else {
                    notLoggedInState(state)
                            .warnings(listOf("Login failed please try again"))
                            .buildUpdate()
                }
            }
            else -> {
                Update(state)
            }
        }
    }

    override fun view(state: Any, control: UiAppControl): DslElement {

        val rootDiv = div {}

        menu(rootDiv, state)

        val containerDiv = div("container") { }

        rootDiv.append(containerDiv)

        when (state) {
            is NotLoggedInState -> {
                notLoggedInView(state, containerDiv)
            }
            is LoggedInState -> {
                loggedInView(containerDiv, state)
            }
        }

        // the footer
        footer(rootDiv, state)

        return rootDiv
    }

    private fun loggedInView(containerDiv: DslDiv, state: LoggedInState) {
        containerDiv.append {
            when (state.pageName) {
                HOME -> {
                    heading(1) { text("Home") }

                    div("row") {
                        p { text("Welcome ${state.username}") }
                    }
                }
                INVOICES -> {
                    heading(1) { text("Invoices") }
                }
                INVOICE_TYPES -> {
                    heading(1) { text("Invoice Types") }
                }
                SETTINGS -> {
                    heading(1) { text("Settings") }
                }
            }
        }
    }


    private fun notLoggedInView(state: NotLoggedInState, containerDiv: DslDiv) {
        if (state.warnings.isNotEmpty()) {
            state.warnings.forEach {
                containerDiv.append {
                    div("alert", "alert-warning") {
                        text(it)
                    }
                }
            }
        }

        containerDiv.append {
            div("row") {
                div("col-md-6", "justify-content-center") {
                    form {
                        heading(2) { text("Login") }

                        div("form-group") {
                            label { text("Username") }
                            textField(::UsernameEntered, "form-control") {
                                value(state.username)
                                autoFocus()
                            }
                        }
                        div("form-group") {
                            label { text("Password") }
                            passwordField(::PasswordEntered, "form-control") {
                                value(state.password)
                            }
                        }
                        div("form-group") {
                            button(::Login, "btn", "btn-primary") {
                                text("Login")
                            }
                        }
                    }
                }
            }
        }
    }


}
