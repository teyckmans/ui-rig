package eu.rigeldev.uirig

import eu.rigeldev.uirig.core.UiAppControl
import kotlin.browser.document

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
class UiRig {
    companion object {
        fun run(uiApp : UiRigApplication) {
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
    }
}