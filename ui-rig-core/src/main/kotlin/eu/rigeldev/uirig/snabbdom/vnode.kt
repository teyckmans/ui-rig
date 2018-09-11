@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom

import eu.rigeldev.uirig.snabbdom.helpers.AttachData
import eu.rigeldev.uirig.snabbdom.modules.*
import kotlin.js.*
import kotlin.js.Json
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*

sealed external class VNodeParent {
    var sel: String?
    var children: Array<dynamic /* String | VNode */>?
    var elm: Node?
    var text: String?
    var key: dynamic /* String | Number */
}

external interface VNode : VNodeParent {
    var data: VNodeData?
}

sealed external class VNodeDataParent {
    var props: Props? get() = definedExternally; set(value) = definedExternally
    var attrs: Attrs? get() = definedExternally; set(value) = definedExternally
    var `class`: Classes? get() = definedExternally; set(value) = definedExternally
    var style: VNodeStyle? get() = definedExternally; set(value) = definedExternally
    var dataset: Dataset? get() = definedExternally; set(value) = definedExternally
    var on: On? get() = definedExternally; set(value) = definedExternally
    var hero: Hero? get() = definedExternally; set(value) = definedExternally
    var attachData: AttachData? get() = definedExternally; set(value) = definedExternally
    var hook: Hooks? get() = definedExternally; set(value) = definedExternally
    var key: dynamic /* String | Number */ get() = definedExternally; set(value) = definedExternally
    var ns: String? get() = definedExternally; set(value) = definedExternally

}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeDataParent.get(key: String): Any? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeDataParent.set(key: String, value: Any) {
    asDynamic()[key] = value
}

external interface VNodeData : VNodeDataParent {

    var fn: (() -> VNode)? get() = definedExternally; set(value) = definedExternally
    var args: Array<Any>? get() = definedExternally; set(value) = definedExternally

}
external fun vnode(sel: String?, data: Any?, children: Array<dynamic /* String | VNode */>?, text: String?, elm: Element): VNode = definedExternally
external fun vnode(sel: String?, data: Any?, children: Array<dynamic /* String | VNode */>?, text: String?, elm: Text): VNode = definedExternally
external fun vnode(sel: String?, data: Any?, children: Array<dynamic /* String | VNode */>?, text: String?, elm: Nothing?): VNode = definedExternally
