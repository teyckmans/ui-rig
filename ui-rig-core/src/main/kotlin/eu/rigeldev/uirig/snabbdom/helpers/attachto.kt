@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.helpers

import eu.rigeldev.uirig.snabbdom.VNode
import org.w3c.dom.Element
import org.w3c.dom.Node

external interface AttachData {
    var placeholder: Any? get() = definedExternally; set(value) = definedExternally
    var real: Node? get() = definedExternally; set(value) = definedExternally
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun AttachData.get(key: String): Any? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun AttachData.set(key: String, value: Boolean) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun AttachData.set(key: String, value: String) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun AttachData.set(key: String, value: Number) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun AttachData.get(i: Number): Any? = asDynamic()[i]

@Suppress("NOTHING_TO_INLINE")
inline operator fun AttachData.set(i: Number, value: Boolean) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun AttachData.set(i: Number, value: String) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun AttachData.set(i: Number, value: Number) {
    asDynamic()[i] = value
}

external fun attachTo(target: Element, vnode: VNode): VNode = definedExternally
