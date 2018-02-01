package eu.rigeldev.uirig.commands.http

import eu.rigeldev.uirig.core.UiAppControl
import eu.rigeldev.uirig.commands.Command
import org.w3c.dom.url.URL
import org.w3c.xhr.XMLHttpRequest

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
class HttpCommand(
        private val url: URL,
        private val messageCreator: (readyState : HttpRequestReadyState, httpStatus : Short?, responseText: String?) -> Any?,
        private val requestBody: String?,
        private val method : HttpMethod?,
        private val debug : Boolean = false)
    : Command {

    val xhttp : XMLHttpRequest

    val methodName : String
    val urlAsText : String
    val loggingPrefix : String

    init {
        xhttp = XMLHttpRequest()

        methodName = method.toString()
        urlAsText = url.toString()

        loggingPrefix = "[$methodName][$urlAsText]"
    }

    override fun execute(appControl: UiAppControl) {
        xhttp.onreadystatechange = this.readyStateChangeListener(appControl)

        xhttp.open(methodName, urlAsText, true)

        try {
            if (requestBody == null) {
                xhttp.send()
            } else {
                xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
                xhttp.send(requestBody)
            }
        }
        catch (e : Exception) {
            error("$e")

            appControl.send(messageCreator(HttpRequestReadyState.UNSENT, null, null))
        }
    }

    private fun readyStateChangeListener(appControl: UiAppControl): (dynamic) -> Unit {
        return fun(_: dynamic) {
            val state = this.mapReadyState(xhttp.readyState)

            debug("$loggingPrefix state change to => $state ")

            val responseText = xhttp.responseText
            if (state == HttpRequestReadyState.DONE && responseText != "") {
                debug("statusText ${xhttp.status}")
                debug("responseBody => ${xhttp.responseText}")

                appControl.send(messageCreator(state, xhttp.status, xhttp.responseText))
            } else {
                appControl.send(messageCreator(state, xhttp.status, null))
            }
        }
    }

    private fun mapReadyState(readyState : Short) : HttpRequestReadyState {
        return when (readyState) {
            XMLHttpRequest.UNSENT -> HttpRequestReadyState.UNSENT
            XMLHttpRequest.OPENED -> HttpRequestReadyState.OPENED
            XMLHttpRequest.HEADERS_RECEIVED -> HttpRequestReadyState.HEADERS_RECEIVED
            XMLHttpRequest.LOADING -> HttpRequestReadyState.LOADING
            XMLHttpRequest.DONE -> HttpRequestReadyState.DONE
            else -> {
                throw IllegalStateException("encountered XMLHttpRequest.readyState $readyState don't know what to do")
            }
        }
    }

    private fun debug(debugMessage : String) {
        if (debug) {
            println("$loggingPrefix " + debugMessage)
        }
    }

    private fun error(errorMessage : String) {
        println("$loggingPrefix [ERROR] $errorMessage")
    }
}