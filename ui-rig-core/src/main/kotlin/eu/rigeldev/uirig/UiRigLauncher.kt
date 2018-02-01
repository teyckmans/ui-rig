package eu.rigeldev.uirig

import eu.rigeldev.uirig.core.UiAppControl
import kotlin.browser.document

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
class UiRigLauncher private constructor (val uiApp: UiRigApplication) {

    fun run() {
        if (document.body != null) {
            start(uiApp)
        } else {
            document.addEventListener("DOMContentLoaded", { start(uiApp) })
        }
    }

    private fun start(uiApp : UiRigApplication) {
        val uiAppControl = UiAppControl(uiApp)
        uiAppControl.init()
    }

    companion object {
        fun uiRigApplication(uiApp : UiRigApplication) : UiRigLauncher {
            return UiRigLauncher(uiApp)
        }
    }
}