package hello

import eu.rigeldev.uirig.UiRig
import kotlin.test.Test

class HelloAppTest {
    @Test
    fun testHelloApp() {
        UiRig.run(HelloApp())
    }
}