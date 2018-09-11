@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS", "EXTERNAL_DELEGATION", "NESTED_CLASS_IN_EXTERNAL_INTERFACE")

package eu.rigeldev.uirig.snabbdom;

import org.w3c.dom.*

external interface DOMAPI {
    var createElement: (tagName: Any) -> HTMLElement
    var createElementNS: (namespaceURI: String, qualifiedName: String) -> Element
    var createTextNode: (text: String) -> Text
    var createComment: (text: String) -> Comment
    var insertBefore: (parentNode: Node, newNode: Node, referenceNode: Node?) -> Unit
    var removeChild: (node: Node, child: Node) -> Unit
    var appendChild: (node: Node, child: Node) -> Unit
    var parentNode: (node: Node) -> Node
    var nextSibling: (node: Node) -> Node
    var tagName: (elm: Element) -> String
    var setTextContent: (node: Node, text: String?) -> Unit
    var getTextContent: (node: Node) -> String?
    var isElement: (node: Node) -> Boolean
    var isText: (node: Node) -> Boolean
    var isComment: (node: Node) -> Boolean
}
external var htmlDomApi: DOMAPI = definedExternally
