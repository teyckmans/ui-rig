package eu.rigeldev.uirig.demo.views

import eu.rigeldev.uirig.demo.Logout
import eu.rigeldev.uirig.demo.ToPage
import eu.rigeldev.uirig.demo.state.LoggedInState
import eu.rigeldev.uirig.demo.state.PageName
import eu.rigeldev.uirig.view.DslDiv

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
fun menu(rootDiv: DslDiv, state: Any) {
    rootDiv.append {

        nav("navbar", "navbar-expand-lg", "navbar-light", "bg-light") {
            a({ ToPage(PageName.HOME) }, "navbar-brand") {
                text("KTrack")
            }

            if (state is LoggedInState) {
                if (state.roles.contains("ROLE_USER")) {
                    div("collapse", "navbar-collapse") {
                        // TODO active cssClass
                        ul("navbar-nav", "mr-auto") {
                            li("nav-item") {
                                a({ ToPage(PageName.HOME) }, "nav-link") { text("Start") }
                            }
                            li("nav-item") {
                                a({ ToPage(PageName.INVOICES) }, "nav-link") { text("Invoices") }
                            }
                        }

                        ul("navbar-nav", "mr-0") {
                            li("nav-item") {
                                a({ ToPage(PageName.INVOICE_TYPES) }, "nav-link") { text("Types") }
                            }
                            li("nav-item") {
                                a({ ToPage(PageName.SETTINGS) }, "nav-link") { text("Settings") }
                            }
                            li("nav-item") {
                                a(::Logout, "nav-link") { text("Logout") }
                            }
                        }
                    }
                } else {
                    ul("navbar-nav", "mr-0") {
                        li("nav-item") {
                            a(::Logout, "nav-link") { text("Logout") }
                        }
                    }
                }
            }
        }

    }
}