@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")
@file:JsModule("snabbdom/h")

package eu.rigeldev.uirig.snabbdom

external fun h(sel: String): VNode = definedExternally
external fun h(sel: String, data: VNodeData): VNode = definedExternally
external fun h(sel: String, children: Array<dynamic>): VNode = definedExternally
external fun h(sel: String, data: VNodeData, children: Array<dynamic>): VNode = definedExternally
