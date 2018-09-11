@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom;

external interface ThunkData : VNodeDataParent {
    var fn: (() -> VNode)?
    var args: Array<Any>?
}
external interface Thunk : VNodeParent {
    var data: ThunkData?
}
external interface ThunkFn

@Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
inline operator fun ThunkFn.invoke(sel: String, fn: Function<*>, args: Array<Any>): Thunk {
    return asDynamic()(sel, fn, args) as Thunk
}

@Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
inline operator fun ThunkFn.invoke(sel: String, key: Any, fn: Function<*>, args: Array<Any>): Thunk {
    return asDynamic()(sel, key, fn, args) as Thunk
}

external var thunk: ThunkFn = definedExternally
