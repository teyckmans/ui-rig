package eu.rigeldev.uirig.view

import com.github.snabbdom.*
import eu.rigeldev.uirig.core.UiAppControl
import org.w3c.dom.HTMLInputElement
import kotlin.reflect.KProperty

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

    @Suppress("UnsafeCastFromDynamic")
    var vNodeData: VNodeData = js("{}")

    init {
        vNodeData.on = vNodeDataOn()
        vNodeData.attrs = vNodeDataAttrs()
        vNodeData.`class` = vNodeDataClasses().apply {
            addAll(cssClasses)
        }

        /*vnodeData.hero = assertSafeCast(Any())
        vnodeData.attachData = assertSafeCast(Any())
        vnodeData.hook = assertSafeCast(Any())
        vnodeData.ns = undefined
        vnodeData.fn = undefined
        vnodeData.args = arrayOf()
        vnodeData.props = assertSafeCast(Any())
        vnodeData.attrs = vNodeDataAttr()
        vnodeData.`class` = assertSafeCast(Any())
        vnodeData.style = assertSafeCast(Any())
        vnodeData.dataset = assertSafeCast(Any())
        vnodeData.on = vNodeDataOn()
        vnodeData.key = undefined*/
    }

//    @Suppress("UnsafeCastFromDynamic")
//    fun vNodeData() : VNodeData = js("{}")

    @Suppress("UnsafeCastFromDynamic")
    fun vNodeDataOn() : On = js("{}")

    @Suppress("UnsafeCastFromDynamic")
    fun vNodeDataAttrs() : Attrs = js("{}")

    @Suppress("UnsafeCastFromDynamic")
    fun vNodeDataClasses() : Classes = js("{}")

    /*private val vNodeDataLookUp = { vnodeData }

    val hero: Hero by DelegateProperty(vNodeDataLookUp)
    val attachData: AttachData by DelegateProperty(vNodeDataLookUp)
    val hook: Hooks by DelegateProperty(vNodeDataLookUp)
    var ns: String? by DelegateProperty(vNodeDataLookUp)
    var fn: (() -> VNode)? by DelegateProperty(vNodeDataLookUp)
    val args: Array<dynamic> by DelegateProperty(vNodeDataLookUp)
    val props: Props by DelegateProperty(vNodeDataLookUp)
    val classes: Classes by DelegateProperty(vNodeDataLookUp, "class")
    val styles: VNodeStyle by DelegateProperty(vNodeDataLookUp, "style")
    val dataset: Dataset by DelegateProperty(vNodeDataLookUp)
    val on: On by DelegateProperty(vNodeDataLookUp)
    var key: dynamic by DelegateProperty(vNodeDataLookUp)*/

    fun <T> assertSafeCast(obj: Any): T {
        @Suppress("UNCHECKED_CAST")
        return obj as T
    }

    protected fun <IT : DslElement> initTag(tag: IT, init: IT.() -> Unit) : IT {
        tag.init()
        children.add(tag)
        return tag
    }

    protected fun <IT : DslElement> initTag(tag: IT) : IT {
        children.add(tag)
        return tag
    }

    override fun prepare(appControl: UiAppControl) {
        // only a few implementations need this - overwrite when needed.
        children.forEach { child -> child.prepare(appControl) }
    }

    override fun render(): Any {

        cssClasses.forEach({cssClass -> vNodeData.`class`!!.add(cssClass)})

        // TODO attributes
        return h(name, vNodeData, children.map(DslElement::render).toTypedArray())
    }

    /**
     * generic attribute method
     */
    fun attr(name : String, value: String) {
        vNodeData.attrs!![name] = value
    }
}

class DelegateProperty(val objectLookUp: () -> Any, val propertyName: String? = null){
    operator fun getValue(thisRef: Any?, property: KProperty<*>): dynamic =
            objectLookUp()._get(propertyName ?: property.name)

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: dynamic) {
        objectLookUp()._set(propertyName ?: property.name, value)
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

operator fun Classes.plusAssign(className: String){
    add(className)
}

operator fun Classes.minusAssign(className: String){
    remove(className)
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
    fun form(vararg cssClasses : String, init : DslForm.() -> Unit) = initTag(DslForm(*cssClasses), init)
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
    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)

        vNodeData.on!!.click = {
            appControl.send(action())
        }

    }
}



class DslForm(vararg cssClasses : String) : DslBodyTag("form", *cssClasses) {

    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)

        vNodeData.on!!.submit = { _ ->
            console.log("form submit - oh oh...")
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

    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)

        vNodeData.on!!.input = { event ->
                val htmlInputElement = event.target as HTMLInputElement

                appControl.send(action(htmlInputElement.value))
            }
    }

    fun value(value : String) {
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

    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)

        vNodeData.on!!.input = { event ->
            val htmlInputElement = event.target as HTMLInputElement

            appControl.send(action(htmlInputElement.value))
        }
    }

    fun value(value : String) {
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

    override fun prepare(appControl: UiAppControl) {
        super.prepare(appControl)

        super.attr("type", "button")

        vNodeData.on!!.click = {
            appControl.send(action())
        }

    }
}

class DslTable(vararg cssClasses : String) : DslTag("table", cssClasses.asList()) {
    fun thead(vararg cssClasses : String, init : DslTableHead.() -> Unit) = initTag(DslTableHead(*cssClasses), init)
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