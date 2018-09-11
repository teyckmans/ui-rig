package eu.rigeldev.uirig.core

import eu.rigeldev.uirig.snabbdom.*
import eu.rigeldev.uirig.snabbdom.modules.*
import eu.rigeldev.uirig.UiRigApplication
import eu.rigeldev.uirig.update.Update
import kotlin.browser.document
import kotlin.browser.window

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
class UiAppControl internal constructor(private val app: UiRigApplication) {

    private var state: Any? = null
    private val patch: Patch = init(
            arrayOf(
                    classModule,
                    attributesModule,
                    propsModule,
                    styleModule,
                    eventListenersModule,
                    datasetModule
            )
    )
    private var currentNode: VNode? = null
    private val messageQueue: MessageQueue = MessageQueue(this)

    fun init() {
        val init = app.init()

        handleUpdate(init)
    }

    private fun handleUpdate(update : Update) {
        val stateHasChanged = update.state != state

        if (stateHasChanged) {
            state = update.state

            val dslElement = app.view(state!!, this)

            dslElement.prepare(this)
            val vNode = this.assertSafeCastToVNode(dslElement.render())

            if (currentNode == null) {
                patch.invoke(document.getElementById("app"), vNode)
            } else {
                patch.invoke(currentNode, vNode)
            }

            currentNode = vNode
        }

        if (update.command != null) {
            window.setTimeout({ update.command.execute(this) }, 0)
        }
    }

    private fun assertSafeCastToVNode(obj: Any): VNode {
        @Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
        return obj as VNode
    }

    fun handleMessage(message : Any) {
        val update = app.update(message, state!!)

        handleUpdate(update)
    }

    fun send(message : Any?) {
        if (message != null) {
            messageQueue.addMessage(message)
        }
    }
}