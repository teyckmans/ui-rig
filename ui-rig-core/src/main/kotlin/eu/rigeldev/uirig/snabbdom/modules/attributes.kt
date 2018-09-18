@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.modules

import eu.rigeldev.uirig.snabbdom.Module
import eu.rigeldev.uirig.snabbdom._get
import eu.rigeldev.uirig.snabbdom._set

@JsModule("snabbdom/modules/attributes")
external val attributesModule_ext: dynamic = definedExternally
val attributesModule: Module = attributesModule_ext.default

external interface Attrs

operator fun Attrs.get(key: String): dynamic = this._get(key)
operator fun Attrs.set(key: String, value: String) { this._set(key, value) }
operator fun Attrs.set(key: String, value: Number) { this._set(key, value) }
operator fun Attrs.set(key: String, value: Boolean) { this._set(key, value) }