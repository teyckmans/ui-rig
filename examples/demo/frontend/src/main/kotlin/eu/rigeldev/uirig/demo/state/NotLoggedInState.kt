package eu.rigeldev.uirig.demo.state

import eu.rigeldev.uirig.update.Update
import eu.rigeldev.uirig.commands.Command

class NotLoggedInState private constructor(builder: NotLoggedInStateBuilder) {

    val baseApiUrl: String
    val username: String
    val password: String
    val warnings: List<String>

    init {
        this.baseApiUrl = builder.baseApiUrl
        this.username = builder.username
        this.password = builder.password
        this.warnings = builder.warnings
    }

    override fun toString(): String {
        return "NotLoggedInState(baseApiUrl='$baseApiUrl', username='$username', password='$password', warnings=$warnings)"
    }

    class NotLoggedInStateBuilder {
        var baseApiUrl: String = ""
        var username: String = ""
        var password: String = ""

        var warnings: List<String> = emptyList()

        fun from(notLoggedInState: NotLoggedInState): NotLoggedInStateBuilder {
            this.baseApiUrl = notLoggedInState.baseApiUrl
            this.username = notLoggedInState.username
            this.password = notLoggedInState.password
            this.warnings = ArrayList(notLoggedInState.warnings)

            return this
        }

        fun from(loggedInState: LoggedInState) : NotLoggedInStateBuilder {
            this.baseApiUrl = loggedInState.baseApiUrl
            this.username = loggedInState.username
            this.warnings = ArrayList(loggedInState.warnings)

            return this
        }

        fun baseApiUrl(baseApiUrl: String): NotLoggedInStateBuilder {
            this.baseApiUrl = baseApiUrl

            return this
        }

        fun username(username: String): NotLoggedInStateBuilder {
            this.username = username

            return this
        }

        fun password(password: String): NotLoggedInStateBuilder {
            this.password = password

            return this
        }

        fun warnings(warnings: List<String>): NotLoggedInStateBuilder {
            this.warnings = warnings

            return this
        }

        fun build(): NotLoggedInState {
            return NotLoggedInState(this)
        }

        fun buildUpdate() : Update {
            return Update(this.build())
        }

        fun buildUpdate(command : Command) : Update {
            return Update(this.build(), command)
        }

    }

    companion object {
        fun notLoggedInState(): NotLoggedInStateBuilder {
            return NotLoggedInStateBuilder()
        }

        fun notLoggedInState(notLoggedInState : NotLoggedInState) : NotLoggedInStateBuilder {
            return this.notLoggedInState()
                    .from(notLoggedInState)
        }

        fun notLoggedInState(loggedInState : LoggedInState) : NotLoggedInStateBuilder {
            return this.notLoggedInState()
                    .from(loggedInState)
        }
    }
}