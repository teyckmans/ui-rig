@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.modules

import eu.rigeldev.uirig.snabbdom.*

external interface Module {
    var pre: PreHook?
    var create: CreateHook?
    var update: UpdateHook?
    var destroy: DestroyHook?
    var remove: RemoveHook?
    var post: PostHook?
}
