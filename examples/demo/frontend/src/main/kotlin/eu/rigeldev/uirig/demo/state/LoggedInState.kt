package eu.rigeldev.uirig.demo.state

import eu.rigeldev.uirig.update.Update

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
class LoggedInState private constructor(builder : LoggedInStateBuilder) {

    val baseApiUrl : String
    val username : String
    val roles : List<String>
    val warnings : List<String>
    val pageName : PageName

    init {
        this.baseApiUrl = builder.baseApiUrl
        this.username = builder.username
        this.roles = builder.roles
        this.warnings = builder.warnings
        this.pageName = builder.pageName
    }

    override fun toString(): String {
        return "LoggedInState(baseApiUrl='$baseApiUrl', username='$username', roles=$roles, warnings=$warnings, pageName=$pageName)"
    }

    class LoggedInStateBuilder {
        var baseApiUrl : String = ""
        var username : String = ""
        var roles : List<String> = emptyList()
        var warnings : List<String> = emptyList()
        var pageName : PageName = PageName.HOME

        fun from(notLoggedInState: NotLoggedInState): LoggedInStateBuilder {
            this.baseApiUrl = notLoggedInState.baseApiUrl
            this.username = notLoggedInState.username
            this.roles = emptyList()
            this.warnings = emptyList()
            this.pageName = PageName.HOME

            return this
        }

        fun from(loggedInState: LoggedInState): LoggedInStateBuilder {
            this.baseApiUrl = loggedInState.baseApiUrl
            this.username = loggedInState.username
            this.roles = ArrayList(loggedInState.roles)
            this.warnings = ArrayList(loggedInState.warnings)
            this.pageName = loggedInState.pageName

            return this
        }

        fun baseApiUrl(baseApiUrl: String): LoggedInStateBuilder {
            this.baseApiUrl = baseApiUrl

            return this
        }

        fun username(username: String): LoggedInStateBuilder {
            this.username = username

            return this
        }

        fun roles(roles: List<String>): LoggedInStateBuilder {
            this.roles = roles

            return this
        }

        fun warnings(warnings: List<String>): LoggedInStateBuilder {
            this.warnings = warnings

            return this
        }

        fun pageName(pageName: PageName): LoggedInStateBuilder {
            this.pageName = pageName

            return this
        }

        fun build(): LoggedInState {
            return LoggedInState(this)
        }

        fun buildUpdate() : Update {
            return Update(this.build())
        }
    }

    companion object {
        fun loggedInState() : LoggedInStateBuilder {
            return LoggedInStateBuilder()
        }

        fun loggedInState(notLoggedInState : NotLoggedInState) : LoggedInStateBuilder {
            return this.loggedInState()
                    .from(notLoggedInState)
        }

        fun loggedInState(loggedInState : LoggedInState) : LoggedInStateBuilder {
            return this.loggedInState()
                    .from(loggedInState)
        }
    }
}