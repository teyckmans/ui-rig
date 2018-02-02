package eu.rigeldev.uirig.demo

import eu.rigeldev.uirig.demo.state.PageName

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */

class Login

data class UsernameEntered(val username: String)
data class PasswordEntered(val password: String)

class Logout

class ToPage(val pageName : PageName)



