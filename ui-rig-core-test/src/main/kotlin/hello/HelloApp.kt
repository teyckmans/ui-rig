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
        println(message)

        if (state is HelloAppState) {
            when (message) {
                is SetValueMessage -> return Update(HelloAppState(message.value, state.valueList))
                is SubmitMessage -> return this.doSubmit(state)
                is FormSubmitMessage -> return this.doSubmit(state)
                is ValueMouseOverMessage ->
                    return Update(HelloAppState(
                            state.value,
                            state.valueList,
                            message.value
                    ))
                is ValueMouseOutMessage ->
                    return Update(HelloAppState(
                            state.value,
                            state.valueList,
                            ""
                    ))
                else ->
                    return Update(state)
            }
        } else {
            return Update(state)
        }
    }

    private fun doSubmit(state: HelloAppState): Update {
        val newValueList = ArrayList<String>()

        newValueList.addAll(state.valueList)
        if (state.value.isNotEmpty()) {
            newValueList.add(state.value)
        }

        return Update(HelloAppState("", newValueList))
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
                        on.focus = {event -> "got event of type: " + event.type + " for button" }
                        on.blur = {event -> "got event of type: " + event.type + " for button" }
                    }
                }

                if (state.valueList.isEmpty()) {
                    text("Value list is still empty")
                } else {
                    ul {
                        for (value in state.valueList) {


                            val cssClasses = ArrayList<String>()

                            if (state.hoverValue == value) {
                                cssClasses.add("li-hover")
                            }

                            li (*cssClasses.toTypedArray()){
                                text(value)

                                on.mouseOver = { ValueMouseOverMessage(value) }
                                on.mouseOut = { ValueMouseOutMessage(value) }
                            }
                        }
                    }
                }

                on.mouseMove = { event -> "got mouse move ${event.offsetX}:${event.offsetY}"}

            }
        } else {
            return div {
                text("How embarrassing....")
            }
        }
    }

}