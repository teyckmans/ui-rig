@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.modules

import eu.rigeldev.uirig.snabbdom.Module
import eu.rigeldev.uirig.snabbdom._get
import eu.rigeldev.uirig.snabbdom._set

@JsModule("snabbdom/modules/props")
external val propsModule_ext: dynamic = definedExternally
val propsModule: Module = propsModule_ext.default

external interface Props

operator fun Props.get(key: String): dynamic = this._get(key)
operator fun Props.set(key: String, value: dynamic): Unit { this._set(key, value) }
