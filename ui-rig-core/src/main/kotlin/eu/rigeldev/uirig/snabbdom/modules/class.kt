@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.modules

import eu.rigeldev.uirig.snabbdom.Module
import eu.rigeldev.uirig.snabbdom._get
import eu.rigeldev.uirig.snabbdom._set

@JsModule("snabbdom/modules/class")
external val classModule_ext: dynamic = definedExternally
val classModule: Module = classModule_ext.default

external interface Classes

operator fun Classes.get(key: String): Boolean = this._get(key)
operator fun Classes.set(key: String, value: Boolean) { this._set(key, value) }