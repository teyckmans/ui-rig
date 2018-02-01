package eu.rigeldev.uirig

import eu.rigeldev.uirig.core.UiAppControl
import eu.rigeldev.uirig.view.DslElement
import eu.rigeldev.uirig.update.Update

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
interface UiRigApplication {

    fun init() : Update

    fun update(message : Any, state : Any) : Update

    fun view(state: Any, control: UiAppControl) : DslElement
}

