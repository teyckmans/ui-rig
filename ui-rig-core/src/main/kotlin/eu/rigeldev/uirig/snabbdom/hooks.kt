@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom;

external interface Hooks {
    var pre: PreHook? get() = definedExternally; set(value) = definedExternally
    var init: InitHook? get() = definedExternally; set(value) = definedExternally
    var create: CreateHook? get() = definedExternally; set(value) = definedExternally
    var insert: InsertHook? get() = definedExternally; set(value) = definedExternally
    var prepatch: PrePatchHook? get() = definedExternally; set(value) = definedExternally
    var update: UpdateHook? get() = definedExternally; set(value) = definedExternally
    var postpatch: PostPatchHook? get() = definedExternally; set(value) = definedExternally
    var destroy: DestroyHook? get() = definedExternally; set(value) = definedExternally
    var remove: RemoveHook? get() = definedExternally; set(value) = definedExternally
    var post: PostHook? get() = definedExternally; set(value) = definedExternally
}

typealias PreHook = (() -> Any) -> dynamic
typealias InitHook = ((vNode: VNode) -> Any) -> dynamic
typealias CreateHook = ((emptyVNode: VNode, vNode: VNode) -> Any) -> dynamic
typealias InsertHook = ((vNode: VNode) -> Any) -> dynamic
typealias PrePatchHook = ((oldVNode: VNode, vNode: VNode) -> Any) -> dynamic
typealias UpdateHook = ((oldVNode: VNode, vNode: VNode) -> Any) -> dynamic
typealias PostPatchHook = ((oldVNode: VNode, vNode: VNode) -> Any) -> dynamic
typealias DestroyHook = ((vNode: VNode) -> Any) -> dynamic
typealias RemoveHook = ((vNode: VNode, removeCallback: () -> Unit) -> Any) -> dynamic
typealias PostHook = (() -> Any) -> dynamic
