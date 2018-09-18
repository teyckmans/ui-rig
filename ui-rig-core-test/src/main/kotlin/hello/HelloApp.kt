package hello

import eu.rigeldev.uirig.UiRigApplication
import eu.rigeldev.uirig.core.UiAppControl
import eu.rigeldev.uirig.update.Update
import eu.rigeldev.uirig.view.DslElement
import eu.rigeldev.uirig.view.div

class HelloApp : UiRigApplication {
    override fun init(): Update {
        return Update(HelloAppState())
    }

    override fun update(message: Any, state: Any): Update {

        if (state is HelloAppState) {
            println(message)
            if (message is SetValueMessage) {
                return Update(HelloAppState(message.value, state.valueList))
            } else {
                val newValueList = ArrayList<String>()

                newValueList.addAll(state.valueList)
                if (state.value.isNotEmpty()) {
                    newValueList.add(state.value)
                }

                return Update(HelloAppState("", newValueList))
            }
        } else {
            return Update(state)
        }
    }

    override fun view(state: Any, control: UiAppControl): DslElement {
        if (state is HelloAppState) {

            return div {
                text("Hello")

                form(::FormSubmitMessage) {
                    div("form-group") {
                        text("Value: ")
                        textField(::SetValueMessage) {
                            value(state.value)
                            attr("placeholder", "some text")
                        }
                    }
                    button(::SubmitMessage, "btn", "btn-primary") {
                        text("Submit")
                    }
                }

                if (state.valueList.isEmpty()) {
                    text("Value list is still empty")
                } else {
                    ul {
                        for (value in state.valueList) {
                            li {
                                text(value)
                            }
                        }
                    }
                }

            }
        } else {
            return div {
                text("How embarrassing....")
            }
        }
    }

}