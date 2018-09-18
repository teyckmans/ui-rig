@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.modules

import eu.rigeldev.uirig.snabbdom.Module
import eu.rigeldev.uirig.snabbdom._get
import eu.rigeldev.uirig.snabbdom._set

@JsModule("snabbdom/modules/style")
external val styleModule_ext: dynamic = definedExternally
val styleModule : Module = styleModule_ext.default

external interface VNodeStyle{
    var delayed: Delayed?
    var remove: Remove?

    interface Delayed

    interface Remove

}

operator fun VNodeStyle.get(key: String): String = this._get(key)
operator fun VNodeStyle.set(key: String, value: String) = this._set(key, value)

operator fun VNodeStyle.Delayed.get(key: String): String = this._get(key)
operator fun VNodeStyle.Delayed.set(key: String, value: String) = this._set(key, value)

operator fun VNodeStyle.Remove.get(key: String): String = this._get(key)
operator fun VNodeStyle.Remove.set(key: String, value: String) = this._set(key, value)
