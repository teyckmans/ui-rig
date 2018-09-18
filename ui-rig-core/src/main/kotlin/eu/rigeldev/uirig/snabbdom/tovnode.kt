@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom;

import org.w3c.dom.Node

@JsModule("snabbdom/tovnode")
external val toVNodeModule: dynamic = definedExternally

fun toVNode(node: Node, domApi: DOMAPI? = undefined /* null */): VNode = toVNodeModule.default(node, domApi)
