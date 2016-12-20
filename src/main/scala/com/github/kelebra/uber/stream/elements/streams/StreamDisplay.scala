package com.github.kelebra.uber.stream.elements.streams

import com.github.kelebra.uber.stream.DOMAware
import com.github.kelebra.uber.stream.common.Source
import com.github.kelebra.uber.stream.elements.sidebar.StreamControl
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.html.{Anchor, IFrame}

import scalatags.JsDom.all._

sealed case class StreamDisplay(`height in pixels`: Int = 600,
                                `width in pixels`: Int = 800,
                                source: Source,
                                `channel name`: String) extends DOMAware {

  private lazy val element: IFrame = iframe(
    src := source.`rendered url`(`channel name`),
    height := `height in pixels`,
    width := `width in pixels`
  ).render

  private lazy val controls: Anchor = a(
    `class` := "item",
    i(`class` := s"${source.icon} icon"),
    s"${`channel name`}: ",
    i(`class` := "trash icon", style := "margin-left: 1em", onclick := deleteOnClick)
  ).render

  def resize(width: Int, height: Int): Unit = resize(element, width, height)

  def show() = {
    appendToBody(element)
    StreamControl.append(controls)
  }

  private val deleteOnClick: MouseEvent => Unit = event => removeFromBody(element, controls)
}
