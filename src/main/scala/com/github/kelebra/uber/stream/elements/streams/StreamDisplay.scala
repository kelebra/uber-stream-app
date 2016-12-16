package com.github.kelebra.uber.stream.elements.streams

import com.github.kelebra.uber.stream.DOMAware
import com.github.kelebra.uber.stream.common.Source
import com.github.kelebra.uber.stream.elements.sidebar.StreamControl
import org.scalajs.dom.html.{Div, Element, IFrame}
import org.scalajs.dom.{FocusEvent, MouseEvent}

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

    lazy val controlButtons: Div = div(
      `class` := "hidden content",
      style := "display: none;",
      button(
        `class` := "ui inverted icon button",
        i(`class` := "trash icon"),
        onclick := deleteOnClick
      )
    ).render

    lazy val channelDescription = div(
      `class` := "visible content",
      a(
        `class` := "item",
        i(`class` := s"${source.icon} icon"),
        s"${`channel name`}",
        onmouseover := display(controlButtons),
        onmouseout := hide(controlButtons)
      )
    ).render

    div(
      `class` := "ui move reveal",
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

  private def display(control: Element): FocusEvent => Unit = {
    val f = () => control.style.display = "block"
    _: FocusEvent => f()
  }

  private def hide(control: Element): FocusEvent => Unit = {
    val f = () => control.style.display = "none"
    _: FocusEvent => f()
  }
}
