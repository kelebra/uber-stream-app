package com.github.kelebra.uber.stream.elements.streams

import com.github.kelebra.uber.stream.DOMAware
import com.github.kelebra.uber.stream.common.Source
import com.github.kelebra.uber.stream.elements.sidebar.StreamControl
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.html.{Div, Element, IFrame}

import scalatags.JsDom.all._

sealed case class StreamDisplay(`height in pixels`: Int = 600,
                                `width in pixels`: Int = 800,
                                source: Source,
                                `channel name`: String) extends DOMAware {

  lazy val element: IFrame = iframe(
    src := source.`rendered url`(`channel name`),
    height := `height in pixels`,
    width := `width in pixels`
  ).render

  lazy val controls: Div = {

    lazy val controlButtons = a(
      style := "display: none",
      `class` := "item",
      i(`class` := "trash icon", onclick := deleteOnClick),
      "Delete"
    ).render

    lazy val channelDescription = a(
      `class` := "item",
      i(`class` := s"${source.icon} icon"),
      s"${`channel name`}"
    ).render

    channelDescription.onmouseover = toggle(controlButtons, channelDescription)
    controlButtons.onmouseout = toggle(channelDescription, controlButtons)

    div(
      channelDescription,
      controlButtons
    ).render
  }

  def resize(width: Int, height: Int): Unit = {
    element.style.width = width.px
    element.style.height = height.px
  }

  def show() = {
    appendToBody(element)
    StreamControl.append(controls)
  }

  def delete() = removeFromBody(element, controls)

  private val deleteOnClick: MouseEvent => Unit = event => delete()

  private def toggle(toShow: Element, toHide: Element): MouseEvent => Unit = {
    val show = () => toShow.style.display = "block"
    val hide = () => toHide.style.display = "none"
    _: MouseEvent => {
      hide()
      show()
    }
  }
}
