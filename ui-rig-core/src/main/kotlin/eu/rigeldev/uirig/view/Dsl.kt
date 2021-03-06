package eu.rigeldev.uirig.view

import eu.rigeldev.uirig.snabbdom.*
import eu.rigeldev.uirig.core.UiAppControl
import eu.rigeldev.uirig.snabbdom.modules.*
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.Node
import org.w3c.dom.events.Event
import org.w3c.dom.events.UIEvent

/**
 * @author Tom Eyckmans <teyckmans@gmail.com>
 */
@DslMarker
annotation class HtmlDslMarker

interface DslElement {
    fun prepare(appControl: UiAppControl)

    fun render(): Any
}

@HtmlDslMarker
abstract class DslTag(private val name: String,
                      private val cssClasses : List<String>) : DslElement {

    protected val children = arrayListOf<DslElement>()
    protected val attributes = hashMapOf<String, dynamic>()
    protected var vNodeData: VNodeData = js("{}").unsafeCast<VNodeData>()
    val on = DslOn()

    init {
        vNodeData.on = vNodeDataOn()
        vNodeData.attrs = vNodeDataAttrs()
        vNodeData.`class` = vNodeDataClasses().apply {
            addAll(cssClasses)
        }
        vNodeData.props = vNodeDataProps()
        vNodeData.hook = vNodeDataHooks()
    }

    private fun vNodeDataOn() : On = js("{}").unsafeCast<On>()

    private fun vNodeDataAttrs() : Attrs = js("{}").unsafeCast<Attrs>()

    private fun vNodeDataClasses() : Classes = js("{}").unsafeCast<Classes>()

    private fun vNodeDataProps() : Props = js("{}").unsafeCast<Props>()

    private fun vNodeDataHooks() : Hooks = js("{}").unsafeCast<Hooks>()

    protected fun <IT : DslElement> initTag(tag: IT, init: IT.() -> Unit) : IT {
        tag.init()
        children.add(tag)
        return tag
    }

    protected fun <IT : DslElement> initTag(tag: IT) : IT {
        children.add(tag)
        return tag
    }

    protected open fun registerEventHandlers() {

    }

    protected fun prepareOn(appControl: UiAppControl) {
        this.registerEventHandlers()
        this.on.prepare(appControl, vNodeData.on)
    }

    override fun prepare(appControl: UiAppControl) {
        prepareOn(appControl)
        // only a few implementations need this - overwrite when needed.
        children.forEach { child -> child.prepare(appControl) }
    }

    override fun render(): Any {
        cssClasses.forEach { cssClass -> vNodeData.`class`!!.add(cssClass)}

        return h(name, vNodeData, children.map(DslElement::render).toTypedArray())
    }

    /**
     * generic attribute method
     */
    fun attr(name : String, value: String) {
        vNodeData.attrs!![name] = value
    }
}

fun Classes.add(vararg classes: String){
    classes.forEach {
        value ->
        set(value, true)
    }
}

fun Classes.remove(vararg classes: String){
    classes.forEach {
        value ->
        set(value, false)
    }
}

fun Classes.addAll(vararg classes: String){
    add(*classes)
}

fun Classes.addAll(classes : List<String>) {
    classes.forEach { add(it) }
}

fun Classes.removeAll(vararg classes: String){
    remove(*classes)
}

class DslTextElement(private val text : String) : DslElement {

    override fun prepare(appControl: UiAppControl) {
        // nothing to do
    }

    override fun render(): Any {
        return text
    }
}

abstract class DslTagWithText(name : String, vararg cssClasses : String) : DslTag(name, cssClasses.asList()) {

    fun text(text : String) {
        children.add(DslTextElement(text))
    }
}

open class DslBodyTag(name : String, vararg cssClasses : String) : DslTagWithText(name, *cssClasses) {
    fun div(vararg cssClasses : String, init : DslDiv.() -> Unit) = initTag(DslDiv(*cssClasses), init)
    fun p(vararg cssClasses : String, init : DslParagraph.() -> Unit) = initTag(DslParagraph(*cssClasses), init)
    fun a(href : String, vararg cssClasses : String, init : DslAnchor.() -> Unit) = initTag(DslAnchor(href, *cssClasses), init)
    fun heading(level : Int, vararg cssClasses : String, init : DslHeading.() -> Unit) = initTag(DslHeading(level, *cssClasses), init)
    fun form(action : () -> Any, vararg cssClasses : String, init : DslForm.() -> Unit) = initTag(DslForm(action, *cssClasses), init)
    fun nav(vararg cssClasses: String, init : DslNav.() -> Unit) = initTag(DslNav(*cssClasses), init)
    fun footer(vararg cssClasses : String, init : DslFooter.() -> Unit) = initTag(DslFooter(*cssClasses), init)
    fun table(vararg cssClasses : String, init : DslTable.() -> Unit) = initTag(DslTable(*cssClasses), init)

    fun ol(vararg cssClasses : String, init : DslOrderedList.() -> Unit) = initTag(DslOrderedList(*cssClasses), init)
    fun ul(vararg cssClasses : String, init : DslUnOrderedList.() -> Unit) = initTag(DslUnOrderedList(*cssClasses), init)
    fun li(vararg cssClasses : String, init : DslListItem.() -> Unit) = initTag(DslListItem(*cssClasses), init)

    // form related elements
    fun label(vararg cssClasses : String, init: DslLabel.() -> Unit) = initTag(DslLabel(*cssClasses), init)
    fun textField(action : (value : String) -> Any, vararg cssClasses : String) = initTag(DslTextField(action, *cssClasses))
    fun textField(action : (value : String) -> Any, vararg cssClasses : String, init : DslTextField.() -> Unit) = initTag(DslTextField(action, *cssClasses), init)
    fun passwordField(action : (value : String) -> Any, vararg cssClasses : String) = initTag(DslPasswordField(action, *cssClasses))
    fun passwordField(action : (value : String) -> Any, vararg cssClasses : String, init : DslPasswordField.() -> Unit) = initTag(DslPasswordField(action, *cssClasses), init)
    fun button(action : () -> Any, vararg cssClasses : String, init : DslButton.() -> Unit) = initTag(DslButton(action, *cssClasses), init)
    fun a(action : () -> Any, vararg cssClasses : String, init : DslAnchorAction.() -> Unit) = initTag(DslAnchorAction(action, *cssClasses), init)

    /**
     * generic tag method
     */
    fun tag(name : String, vararg cssClasses : String, init : DslBodyTag.() -> Unit) = initTag(DslBodyTag(name, *cssClasses), init)

    fun append(append : DslBodyTag.() -> Unit) : DslBodyTag {
        this.append()
        return this
    }

    fun append(element : DslElement) {
        this.children.add(element)
    }


}

class DslDiv(vararg cssClasses : String) : DslBodyTag("div", *cssClasses)
class DslParagraph(vararg cssClasses : String) : DslBodyTag("p", *cssClasses)
class DslHeading(level : Int, vararg cssClasses : String) : DslBodyTag("h" + level, *cssClasses)

class DslNav(vararg cssClasses : String) : DslBodyTag("nav", *cssClasses)
class DslFooter(vararg cssClasses : String) : DslBodyTag("footer", *cssClasses)
class DslOrderedList(vararg cssClasses : String) : DslBodyTag("ol", *cssClasses)
class DslUnOrderedList(vararg cssClasses : String) : DslBodyTag("ul", *cssClasses)
class DslListItem(vararg cssClasses : String) : DslBodyTag("li", *cssClasses)

class DslLabel(vararg cssClasses : String) : DslTagWithText("label", *cssClasses)

class DslAnchor(private val href: String, vararg cssClasses : String) : DslTagWithText("a", *cssClasses) {
    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)
        super.attr("href", href)
    }
}

class DslAnchorAction(val action : () -> Any, vararg cssClasses : String) : DslTagWithText("a", *cssClasses) {

    override fun registerEventHandlers() {
        on.click = { action.invoke() }
    }

}



class DslForm(val action : () -> Any, vararg cssClasses : String) : DslBodyTag("form", *cssClasses) {

    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)

        vNodeData.on!!.submit = { event : Event ->
            appControl.send(action.invoke())

            event.preventDefault()
            event.stopImmediatePropagation()
            event.stopPropagation()
        }
    }
}

abstract class DslInputTag(val inputType : String, vararg cssClasses : String) : DslTag("input", cssClasses.asList()) {

    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)
        super.attr("type", inputType)
    }
}

class DslTextField(val action : (value : String) -> Any, vararg cssClasses : String) : DslInputTag("text", "input", *cssClasses) {

    private var emptyValueSet = false

    override fun registerEventHandlers() {
        on.input = { event ->
            val htmlInputElement = event.target as HTMLInputElement

            action.invoke(htmlInputElement.value)
        }
    }

    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)

        vNodeData.hook?.update = { oldVNode: VNode, _: VNode ->

            if (emptyValueSet) {
                val oldElement = oldVNode.elm as HTMLInputElement
                oldElement.value = ""
            }

        }
    }

    fun value(value : String) {
        this.emptyValueSet = value.isEmpty()

        super.attr("value", value)
    }

    fun autoFocus() {
        autoFocus(true)
    }

    fun autoFocus(autoFocus: Boolean) {
        super.attr("autofocus", autoFocus.toString())
    }

    fun required() {
        required(true)
    }

    fun required(required : Boolean) {
        super.attr("required", required.toString())
    }

    fun optional() {
        required(false)
    }
}
class DslPasswordField(val action : (value : String) -> Any, vararg cssClasses : String) : DslInputTag("password", "input", *cssClasses) {

    private var emptyValueSet = false

    override fun registerEventHandlers() {
        on.input = { event ->
            val htmlInputElement = event.target as HTMLInputElement

            action.invoke(htmlInputElement.value)
        }
    }

    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)

        vNodeData.hook?.update = { oldVNode: VNode, _: VNode ->

            if (emptyValueSet) {
                val oldElement = oldVNode.elm as HTMLInputElement
                oldElement.value = ""
            }

        }
    }

    fun value(value : String) {
        this.emptyValueSet = value.isEmpty()

        super.attr("value", value)
    }

    fun autoFocus() {
        autoFocus(true)
    }

    fun autoFocus(autoFocus: Boolean) {
        super.attr("autofocus", autoFocus.toString())
    }

    fun required() {
        required(true)
    }

    fun required(required : Boolean) {
        super.attr("required", required.toString())
    }

    fun optional() {
        required(false)
    }
}

class DslButton(val action : () -> Any, vararg cssClasses : String) : DslTagWithText("button", *cssClasses) {

    override fun registerEventHandlers() {
        on.click = { action() }
    }

    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)

        super.attr("type", "button")
    }
}

class DslTable(vararg cssClasses : String) : DslTag("table", cssClasses.asList()) {
    fun thead(vararg cssClasses : String, init : DslTableHead.() -> Unit) = initTag(DslTableHead(*cssClasses), init)
    fun tbody(vararg cssClasses : String, init : DslTableBody.() -> Unit) = initTag(DslTableBody(*cssClasses), init)
}

class DslTableHead(vararg  cssClasses : String) : DslTag("thead", cssClasses.asList()) {
    fun th(vararg cssClasses : String, init : DslTableHeadCell.() -> Unit) = initTag(DslTableHeadCell(*cssClasses), init)
}

class DslTableHeadCell(vararg  cssClasses : String) : DslBodyTag("th", *cssClasses) {

}

class DslTableBody(vararg  cssClasses : String) : DslTag("tbody", cssClasses.asList()) {
    fun tr(vararg cssClasses : String, init : DslTableRow.() -> Unit) = initTag(DslTableRow(*cssClasses), init)
}

class DslTableRow(vararg  cssClasses : String) : DslTag("tr", cssClasses.asList()) {
    fun td(vararg cssClasses : String, init : DslTableCell.() -> Unit) = initTag(DslTableCell(*cssClasses), init)
}

class DslTableCell(vararg  cssClasses : String) : DslBodyTag("td", *cssClasses) {

}

fun div(vararg cssClasses : String, init: DslDiv.() -> Unit) : DslDiv {
    val div = DslDiv(*cssClasses)
    div.init()
    return div
}