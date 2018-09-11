@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom;

import eu.rigeldev.uirig.snabbdom.modules.Module

external fun init(modules: Array<Module?>, domApi: DOMAPI? = definedExternally /* null */): Patch = definedExternally

typealias Patch = (oldVnode: dynamic /* Element | VNode */, vnode: VNode) -> VNode