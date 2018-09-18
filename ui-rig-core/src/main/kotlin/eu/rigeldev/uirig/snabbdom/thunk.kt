@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom;

import org.w3c.dom.Node

@JsModule("snabbdom/thunk")
external val thunkModule: dynamic = definedExternally

external interface ThunkData : VNodeData

external interface Thunk : VNode

fun thunk(sel: String, fn: ()->dynamic, args: Array<dynamic>): Thunk {
    return thunkModule.default(sel, fn, args)
}

fun thunk(sel: String, key: dynamic, fn: ()->dynamic, args: Array<dynamic>): Thunk {
    return thunkModule.default(sel, key, fn, args)
}

