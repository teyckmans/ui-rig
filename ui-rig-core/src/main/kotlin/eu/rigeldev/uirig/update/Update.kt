package eu.rigeldev.uirig.update

import eu.rigeldev.uirig.commands.Command

data class Update(val state: Any, val command: Command? = null)