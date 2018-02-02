package eu.rigeldev.uirig.demo.backend.authentication

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
data class AuthResponse(val success : Boolean, val username : String, val roles : List<String>)