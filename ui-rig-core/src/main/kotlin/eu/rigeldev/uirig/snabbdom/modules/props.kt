@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.modules

external var propsModule: Module = definedExternally

external interface Props

@Suppress("NOTHING_TO_INLINE")
inline operator fun Props.get(key: String): Any? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun Props.set(key: String, value: Boolean) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun Props.set(key: String, value: String) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun Props.set(key: String, value: Number) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun Props.get(i: Number): Any? = asDynamic()[i]

@Suppress("NOTHING_TO_INLINE")
inline operator fun Props.set(i: Number, value: Boolean) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun Props.set(i: Number, value: String) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun Props.set(i: Number, value: Number) {
    asDynamic()[i] = value
}
