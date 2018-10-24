package eu.rigeldev.uirig.view

import eu.rigeldev.uirig.core.UiAppControl
import eu.rigeldev.uirig.snabbdom.modules.On
import org.w3c.dom.DragEvent
import org.w3c.dom.ErrorEvent
import org.w3c.dom.events.*

class DslOn {
    var abort : OnAbort? = null
    var activate : OnActivate? = null
    var beforeActivate : OnBeforeActivate? = null
    var beforeCopy : OnBeforeCopy? = null
    var beforeCut : OnBeforeCut? = null
    var beforeDeActivate : OnBeforeDeActivate? = null
    var beforePaste : OnBeforePaste? = null
    var blur : OnBlur? = null
    var canPlay : OnCanPlay? = null
    var canPlayThrough : OnCanPlayThrough? = null
    var change : OnChange? = null
    var contextMenu : OnContextMenu? = null
    var copy : OnCopy? = null
    var cueChange : OnCueChange? = null
    var cut : OnCut? = null
    var doubleClick : OnDoubleClick? = null
    var deActivate : OnDeActivate? = null
    var drag : OnDrag? = null
    var dragEnd : OnDragEnd? = null
    var dragEnter : OnDragEnter? = null
    var dragLeave : OnDragLeave? = null
    var dragOver : OnDragOver? = null
    var dragStart : OnDragStart? = null
    var drop : OnDrop? = null
    var durationChange : OnDurationChange? = null
    var emptied : OnEmptied? = null
    var ended : OnEnded? = null
    var error : OnError? = null
    var focus : OnFocus? = null
    var input : OnInput? = null
    var invalid : OnInvalid? = null
    var keyDown : OnKeyDown? = null
    var keyPress : OnKeyPress? = null
    var keyUp : OnKeyUp? = null
    var load : OnLoad? = null
    var loadedData : OnLoadedData? = null
    var loadedMetaData : OnLoadedMetaData? = null
    var loadStart : OnLoadStart? = null
    var mouseDown : OnMouseDown? = null
    var mouseEnter : OnMouseEnter? = null
    var mouseLeave : OnMouseLeave? = null
    var mouseMove : OnMouseMove? = null
    var mouseOut : OnMouseOut? = null
    var mouseOver : OnMouseOver? = null
    var mouseUp : OnMouseUp? = null
    var mouseWheel : OnMouseWheel? = null
    var paste : OnPaste? = null
    var pause : OnPause? = null
    var play : OnPlay? = null
    var playing : OnPlaying? = null
    var progress : OnProgress? = null
    var rateChange : OnRateChange? = null
    var reset : OnReset? = null
    var scroll : OnScroll? = null
    var seeked : OnSeeked? = null
    var seeking : OnSeeking? = null
    var select : OnSelect? = null
    var selectStart : OnSelectStart? = null
    var stalled : OnStalled? = null
    var submit : OnSubmit? = null
    var suspend : OnSuspend? = null
    var timeUpdate : OnTimeUpdate? = null
    var volumeChange : OnVolumeChange? = null
    var waiting : OnWaiting? = null
    var ariaRequest : OnAriaRequest? = null
    var command : OnCommand? = null
    var gotPointerCapture : OnGotPointerCapture? = null
    var lostPointerCapture : OnLostPointerCapture? = null
    var touchCancel : OnTouchCancel? = null
    var touchEnd : OnTouchEnd? = null
    var touchMove : OnTouchMove? = null
    var touchStart : OnTouchStart? = null
    var webKitFullScreenChange : OnWebKitFullScreenChange? = null
    var webKitFullScreenError : OnWebKitFullScreenError? = null
    var pointerCancel : OnPointerCancel? = null
    var pointerDown : OnPointerDown? = null
    var pointerEnter : OnPointerEnter? = null
    var pointerLeave : OnPointerLeave? = null
    var pointerMove : OnPointerMove? = null
    var pointerOut : OnPointerOut? = null
    var pointerOver : OnPointerOver? = null
    var pointerUp : OnPointerUp? = null
    var wheel : OnWheel? = null

    fun prepare(control: UiAppControl, vNodeDataOn: On?) {
        if (vNodeDataOn != null) {
            vNodeDataOn.abort = this.createHandler(control, abort)
            vNodeDataOn.activate = this.createHandler(control, activate)
            vNodeDataOn.beforeactivate = this.createHandler(control, beforeActivate)
            vNodeDataOn.beforecopy = this.createHandler(control, beforeCopy)
            vNodeDataOn.beforecut = this.createHandler(control, beforeCut)
            vNodeDataOn.beforedeactivate = this.createHandler(control, beforeDeActivate)
            vNodeDataOn.beforepaste = this.createHandler(control, beforePaste)
            vNodeDataOn.blur = this.createHandler(control, blur)
            vNodeDataOn.canplay = this.createHandler(control, canPlay)
            vNodeDataOn.canplaythrough = this.createHandler(control, canPlayThrough)
            vNodeDataOn.change = this.createHandler(control, change)
            vNodeDataOn.contextmenu = this.createHandler(control, contextMenu)
            vNodeDataOn.copy = this.createHandler(control, copy)
            vNodeDataOn.cuechange = this.createHandler(control, cueChange)
            vNodeDataOn.cut = this.createHandler(control, cut)
            vNodeDataOn.dblclick = this.createHandler(control, doubleClick)
            vNodeDataOn.deactivate = this.createHandler(control, deActivate)
            vNodeDataOn.drag = this.createHandler(control, drag)
            vNodeDataOn.dragend = this.createHandler(control, dragEnd)
            vNodeDataOn.dragenter = this.createHandler(control, dragEnter)
            vNodeDataOn.dragleave = this.createHandler(control, dragLeave)
            vNodeDataOn.dragover = this.createHandler(control, dragOver)
            vNodeDataOn.dragstart = this.createHandler(control, dragStart)
            vNodeDataOn.drop = this.createHandler(control, drop)
            vNodeDataOn.durationchange = this.createHandler(control, durationChange)
            vNodeDataOn.emptied = this.createHandler(control, emptied)
            vNodeDataOn.ended = this.createHandler(control, ended)
            vNodeDataOn.error = this.createHandler(control, error)
            vNodeDataOn.focus = this.createHandler(control, focus)
            vNodeDataOn.input = this.createHandler(control, input)
            vNodeDataOn.invalid = this.createHandler(control, invalid)
            vNodeDataOn.keydown = this.createHandler(control, keyDown)
            vNodeDataOn.keypress = this.createHandler(control, keyPress)
            vNodeDataOn.keyup = this.createHandler(control, keyUp)
            vNodeDataOn.load = this.createHandler(control, load)
            vNodeDataOn.loadeddata = this.createHandler(control, loadedData)
            vNodeDataOn.loadedmetadata = this.createHandler(control, loadedMetaData)
            vNodeDataOn.loadstart = this.createHandler(control, loadStart)
            vNodeDataOn.mousedown = this.createHandler(control, mouseDown)
            vNodeDataOn.mouseenter = this.createHandler(control, mouseEnter)
            vNodeDataOn.mouseleave = this.createHandler(control, mouseLeave)
            vNodeDataOn.mousemove = this.createHandler(control, mouseMove)
            vNodeDataOn.mouseout = this.createHandler(control, mouseOut)
            vNodeDataOn.mouseover = this.createHandler(control, mouseOver)
            vNodeDataOn.mouseup = this.createHandler(control, mouseUp)
            vNodeDataOn.mousewheel = this.createHandler(control, mouseWheel)
            vNodeDataOn.paste = this.createHandler(control, paste)
            vNodeDataOn.pause = this.createHandler(control, pause)
            vNodeDataOn.play = this.createHandler(control, play)
            vNodeDataOn.playing = this.createHandler(control, playing)
            vNodeDataOn.progress = this.createHandler(control, progress)
            vNodeDataOn.ratechange = this.createHandler(control, rateChange)
            vNodeDataOn.reset = this.createHandler(control, reset)
            vNodeDataOn.scroll = this.createHandler(control, scroll)
            vNodeDataOn.seeked = this.createHandler(control, seeked)
            vNodeDataOn.seeking = this.createHandler(control, seeking)
            vNodeDataOn.select = this.createHandler(control, select)
            vNodeDataOn.selectstart = this.createHandler(control, selectStart)
            vNodeDataOn.stalled = this.createHandler(control, stalled)
            vNodeDataOn.submit = this.createHandler(control, submit)
            vNodeDataOn.suspend = this.createHandler(control, suspend)
            vNodeDataOn.timeupdate = this.createHandler(control, timeUpdate)
            vNodeDataOn.volumechange = this.createHandler(control, volumeChange)
            vNodeDataOn.waiting = this.createHandler(control, waiting)
            vNodeDataOn.ariarequest = this.createHandler(control, ariaRequest)
            vNodeDataOn.command = this.createHandler(control, command)
            vNodeDataOn.gotpointercapture = this.createHandler(control, gotPointerCapture)
            vNodeDataOn.lostpointercapture = this.createHandler(control, lostPointerCapture)
            vNodeDataOn.touchcancel = this.createHandler(control, touchCancel)
            vNodeDataOn.touchend = this.createHandler(control, touchEnd)
            vNodeDataOn.touchmove = this.createHandler(control, touchMove)
            vNodeDataOn.touchstart = this.createHandler(control, touchStart)
            vNodeDataOn.webkitfullscreenchange = this.createHandler(control, webKitFullScreenChange)
            vNodeDataOn.webkitfullscreenerror = this.createHandler(control, webKitFullScreenError)
            vNodeDataOn.pointercancel = this.createHandler(control, pointerCancel)
            vNodeDataOn.pointerdown = this.createHandler(control, pointerDown)
            vNodeDataOn.pointerenter = this.createHandler(control, pointerEnter)
            vNodeDataOn.pointerleave = this.createHandler(control, pointerLeave)
            vNodeDataOn.pointermove = this.createHandler(control, pointerMove)
            vNodeDataOn.pointerout = this.createHandler(control, pointerOut)
            vNodeDataOn.pointerover = this.createHandler(control, pointerOver)
            vNodeDataOn.pointerup = this.createHandler(control, pointerUp)
            vNodeDataOn.wheel = this.createHandler(control, wheel)
        }
    }

    private fun <T> createHandler(control: UiAppControl, messageCreator : ((event: T) -> Any)?): ((T) -> Unit)? {
        if (messageCreator == null) {
            return null
        } else {
            return { event  ->
                val message = messageCreator.invoke(event)
                control.send(message)
            }
        }
    }

}

typealias OnAbort = (event : UIEvent) -> Any
typealias OnActivate = (event: UIEvent) -> Any
typealias OnBeforeActivate = (event: UIEvent) -> Any
typealias OnBeforeCopy = (event: dynamic /* ClipboardEvent */) -> Any
typealias OnBeforeCut = (event: dynamic /* ClipboardEvent */) -> Any
typealias OnBeforeDeActivate = (event: UIEvent) -> Any
typealias OnBeforePaste = (event: dynamic /* ClipboardEvent */) -> Any
typealias OnBlur = (event: UIEvent) -> Any
typealias OnCanPlay = (event: Event) -> Any
typealias OnCanPlayThrough = (event: Event) -> Any
typealias OnChange = (event: Event) -> Any
typealias OnContextMenu = (event: dynamic /* PointerEvent */) -> Any
typealias OnCopy = (event: dynamic /* ClipboardEvent */) -> Any
typealias OnCueChange = (event: Event) -> Any
typealias OnCut = (event: dynamic /* ClipboardEvent */) -> Any
typealias OnDoubleClick = (event: MouseEvent) -> Any
typealias OnDeActivate = (event: UIEvent) -> Any
typealias OnDrag = (event: DragEvent) -> Any
typealias OnDragEnd = (event: DragEvent) -> Any
typealias OnDragEnter = (event: DragEvent) -> Any
typealias OnDragLeave = (event: DragEvent) -> Any
typealias OnDragOver = (event: DragEvent) -> Any
typealias OnDragStart = (event: DragEvent) -> Any
typealias OnDrop = (event: DragEvent) -> Any
typealias OnDurationChange = (event: Event) -> Any
typealias OnEmptied = (event: Event) -> Any
typealias OnEnded = (event: dynamic /* MediaStreamErrorEvent */) -> Any
typealias OnError = (event: ErrorEvent) -> Any
typealias OnFocus = (event: FocusEvent) -> Any
typealias OnInput = (event: Event) -> Any
typealias OnInvalid = (event: Event) -> Any
typealias OnKeyDown = (event: KeyboardEvent) -> Any
typealias OnKeyPress = (event: KeyboardEvent) -> Any
typealias OnKeyUp = (event: KeyboardEvent) -> Any
typealias OnLoad = (event: Event) -> Any
typealias OnLoadedData = (event: Event) -> Any
typealias OnLoadedMetaData = (event: Event) -> Any
typealias OnLoadStart = (event: Event) -> Any
typealias OnMouseDown = (event: MouseEvent) -> Any
typealias OnMouseEnter = (event: MouseEvent) -> Any
typealias OnMouseLeave = (event: MouseEvent) -> Any
typealias OnMouseMove = (event: MouseEvent) -> Any
typealias OnMouseOut = (event: MouseEvent) -> Any
typealias OnMouseOver = (event: MouseEvent) -> Any
typealias OnMouseUp = (event: MouseEvent) -> Any
typealias OnMouseWheel = (event: WheelEvent) -> Any
typealias OnPaste = (event: dynamic /* ClipboardEvent */) -> Any
typealias OnPause = (event: Event) -> Any
typealias OnPlay = (event: Event) -> Any
typealias OnPlaying = (event: Event) -> Any
typealias OnProgress = (event: Event) -> Any
typealias OnRateChange = (event: Event) -> Any
typealias OnReset = (event: Event) -> Any
typealias OnScroll = (event: UIEvent) -> Any
typealias OnSeeked = (event: Event) -> Any
typealias OnSeeking = (event: Event) -> Any
typealias OnSelect = (event: UIEvent) -> Any
typealias OnSelectStart = (event: Event) -> Any
typealias OnStalled = (event: Event) -> Any
typealias OnSubmit = (event: Event) -> Any
typealias OnSuspend = (event: Event) -> Any
typealias OnTimeUpdate = (event: Event) -> Any
typealias OnVolumeChange = (event: Event) -> Any
typealias OnWaiting = (event: Event) -> Any
typealias OnAriaRequest = (event: Event) -> Any
typealias OnCommand = (event: Event) -> Any
typealias OnGotPointerCapture = (event: dynamic /* PointerEvent */) -> Any
typealias OnLostPointerCapture = (event: dynamic /* PointerEvent */) -> Any
typealias OnTouchCancel = (event: dynamic /* TouchEvent */) -> Any
typealias OnTouchEnd = (event: dynamic /* TouchEvent */) -> Any
typealias OnTouchMove = (event: dynamic /* TouchEvent */) -> Any
typealias OnTouchStart = (event: dynamic /* TouchEvent */) -> Any
typealias OnWebKitFullScreenChange = (event: Event) -> Any
typealias OnWebKitFullScreenError = (event: Event) -> Any
typealias OnPointerCancel = (event: dynamic /* PointerEvent */) -> Any
typealias OnPointerDown = (event: dynamic /* PointerEvent */) -> Any
typealias OnPointerEnter = (event: dynamic /* PointerEvent */) -> Any
typealias OnPointerLeave = (event: dynamic /* PointerEvent */) -> Any
typealias OnPointerMove = (event: dynamic /* PointerEvent */) -> Any
typealias OnPointerOut = (event: dynamic /* PointerEvent */) -> Any
typealias OnPointerOver = (event: dynamic /* PointerEvent */) -> Any
typealias OnPointerUp = (event: dynamic /* PointerEvent */) -> Any
typealias OnWheel = (event: WheelEvent) -> Any
// TODO MSxxx

