package eu.rigeldev.uirig.snabbdom

fun Any._get(key: dynamic): dynamic {
    val self: dynamic = this
    return self[key]
}

fun Any._set(key: dynamic, value: dynamic){
    val self: dynamic = this
    self[key] = value
}