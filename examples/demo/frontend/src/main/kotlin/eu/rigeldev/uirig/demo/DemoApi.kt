package eu.rigeldev.uirig.demo

import eu.rigeldev.uirig.commands.http.HttpCommand
import eu.rigeldev.uirig.commands.http.HttpMethod
import eu.rigeldev.uirig.commands.http.HttpRequestReadyState
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import org.w3c.dom.url.URL

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
class DemoApi(private val apiBaseUrl: String) {

    fun authenticate(username : String, password : String) : HttpCommand {
        return HttpCommand(
                URL("$apiBaseUrl/authenticate"),
                ::mapToLoginResponseMessage,
                JSON.indented.stringify(AuthRequest(username, password)),
                HttpMethod.POST
        )
    }

    private fun mapToLoginResponseMessage(readyState : HttpRequestReadyState, status : Short?, responseText : String?): Any? {
        return if (readyState == HttpRequestReadyState.DONE) {
            if (200.toShort() == status && responseText != null) {
                val authResponse = JSON.parse(responseText) as AuthResponse

                LoginResponse(authResponse.success, authResponse.roles)
            } else {
                LoginResponse(false, ArrayList())
            }
        } else {
            LoginWorking()
        }
    }
}

@Serializable
data class AuthResponse(val success : Boolean, val username : String, val roles : List<String>)

@Serializable
data class AuthRequest (val username : String, val password : String)

data class LoginResponse(val success : Boolean, val roles : List<String>)

class LoginWorking