package eu.rigeldev.uirig.core

import kotlin.browser.window

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
class MessageQueue(val appControl : UiAppControl,
                   val messageQueue : ArrayList<Any> = ArrayList(),
                   var working : Boolean = false) {

    fun addMessage(message : Any) {
        messageQueue.add(message)

        if (!working) {
            window.setTimeout(
                    ::work,
                    0
            )
            working = true
        }
    }

    fun work() {
        var messageCounter = 0
        var message : Any? = null
        var keepProcessing = true

        while (keepProcessing) {

            message = messageQueue.firstOrNull()

            if (messageCounter < 1000 && message != null) {
                messageQueue.removeAt(0)

                this.appControl.handleMessage(message)

                messageCounter++
            }
            else {
                keepProcessing = false
            }
        }

        if (message == null) {
            working = false
        } else {
            window.setTimeout(::work, 0)
        }
    }

}