@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom.modules

import eu.rigeldev.uirig.snabbdom.Module
import eu.rigeldev.uirig.snabbdom._get
import eu.rigeldev.uirig.snabbdom._set

@JsModule("snabbdom/modules/dataset")
external val datasetModule_ext: dynamic = definedExternally
val datasetModule: Module =  datasetModule_ext.default

external interface Dataset

operator fun Dataset.get(key: String): String = this._get(key)
operator fun Dataset.set(key: String, value: String) { this._set(key, value) }