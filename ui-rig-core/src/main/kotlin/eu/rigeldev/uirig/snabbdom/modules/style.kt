@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.modules

external var styleModule: Module = definedExternally

external interface VNodeStyle{
    var delayed: Delayed?
    var remove: Remove?

    interface Delayed

    interface Remove

}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Remove.get(key: String): Any? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Remove.set(key: String, value: Boolean) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Remove.set(key: String, value: String) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Remove.set(key: String, value: Number) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Remove.get(i: Number): Any? = asDynamic()[i]

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Remove.set(i: Number, value: Boolean) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Remove.set(i: Number, value: String) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Remove.set(i: Number, value: Number) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Delayed.get(key: String): Any? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Delayed.set(key: String, value: Boolean) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Delayed.set(key: String, value: String) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Delayed.set(key: String, value: Number) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Delayed.get(i: Number): Any? = asDynamic()[i]

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Delayed.set(i: Number, value: Boolean) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Delayed.set(i: Number, value: String) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.Delayed.set(i: Number, value: Number) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.get(key: String): Any? = asDynamic()[key]

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.set(key: String, value: Boolean) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.set(key: String, value: String) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.set(key: String, value: Number) {
    asDynamic()[key] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.get(i: Number): Any? = asDynamic()[i]

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.set(i: Number, value: Boolean) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.set(i: Number, value: String) {
    asDynamic()[i] = value
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun VNodeStyle.set(i: Number, value: Number) {
    asDynamic()[i] = value
}
