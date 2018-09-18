package hello

import eu.rigeldev.uirig.UiRigLauncher
import kotlin.test.Test

class HelloAppTest {
    @Test
    fun testHelloApp() {
        UiRigLauncher.uiRigApplication(HelloApp()).run()
    }
}