@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.modules

import eu.rigeldev.uirig.snabbdom.Module

@JsModule("snabbdom/modules/hero")
external val heroModule_ext: dynamic = definedExternally
val heroModule: Module = heroModule_ext.default

external interface Hero {
    var id: String
}
