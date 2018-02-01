package eu.rigeldev.uirig.commands

import eu.rigeldev.uirig.core.UiAppControl

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
interface Command {
    fun execute(appControl: UiAppControl)
}

