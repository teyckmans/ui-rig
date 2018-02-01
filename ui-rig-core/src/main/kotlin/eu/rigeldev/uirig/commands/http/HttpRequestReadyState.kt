package eu.rigeldev.uirig.commands.http

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
enum class HttpRequestReadyState {
    UNSENT,
    OPENED,
    HEADERS_RECEIVED,
    LOADING,
    DONE
}