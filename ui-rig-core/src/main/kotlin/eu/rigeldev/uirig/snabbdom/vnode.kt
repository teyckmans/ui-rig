@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom

import eu.rigeldev.uirig.snabbdom.helpers.AttachData
import eu.rigeldev.uirig.snabbdom.modules.*
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.Text

@JsModule("snabbdom/vnode")
external val vNodeModule: dynamic = definedExternally

external interface VNode {
    var sel: String?
    var children: Array<dynamic /* String | VNode */>?
    var elm: Node?
    var text: String?
    var key: dynamic /* String | Number */
    var data: dynamic
}

external interface VNodeData {
    var props: Props?
    var attrs: Attrs?
    var `class`: Classes?
    var style: VNodeStyle?
    var dataset: Dataset?
    var on: On?
    var hero: Hero?
    var attachData: AttachData?
    var hook: Hooks?
    var key: dynamic /* String | Number */
    var ns: String?
    var fn: (() -> VNode)?
    var args: Array<Any>?
}

operator fun VNodeData.get(key: String): dynamic = this._get(key)
operator fun VNodeData.set(key: String, value: dynamic) = this._set(key, value)

fun vnode(sel: String?, data: Any?, children: Array<VNode>?,
          text: String?, elm: Element?): VNode{
    return vNodeModule.default(sel, data, children, text, elm)
}

fun vnode(sel: String?, data: Any?, children: Array<String>?,
          text: String?, elm: Element?): VNode{
    return vNodeModule.default(sel, data, children, text, elm)
}

fun vnode(sel: String?, data: Any?, children: Array<VNode>?,
          text: String?, elm: Text?): VNode{
    return vNodeModule.default(sel, data, children, text, elm)
}

fun vnode(sel: String?, data: Any?, children: Array<String>?,
          text: String?, elm: Text?): VNode{
    return vNodeModule.default(sel, data, children, text, elm)
}
