package eu.rigeldev.uirig.demo.views

import eu.rigeldev.uirig.demo.state.LoggedInState
import eu.rigeldev.uirig.view.DslDiv

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
fun footer(rootDiv: DslDiv, state: Any) {
    rootDiv.append {
        div("container-fluid") {
            footer {
                div("row") {
                    div("col-md-6") {
                        text(" @ 2018 ")
                        a("https://rigeldev.eu") {
                            text("RigelDev")
                        }
                    }

                    div("col-md-6", "text-right") {
                        if (state is LoggedInState) {
                            p { text("${state.username} : Logged in username") }

                            state.roles.forEach { role ->
                                p { text("$role - ") }
                            }

                        }
                    }
                }
            }
        }
    }
}