package com.github.kelebra.uber.stream.elements.streams

import com.github.kelebra.uber.stream.elements.sidebar.ToggleButton

import scala.collection.mutable
import scalatags.JsDom.all._

object Content {

  private val displays = mutable.Seq.empty[StreamDisplay]

  def +(channel: String, source: Source): Unit =
    displays.+:(StreamDisplay(source = source, `channel name` = channel))

  def -(channel: String, source: Source): Unit =
    displays
      .filter(_.`channel name` == channel)
      .filter(_.source == source).foreach(display => display.element)

  def empty() = div(`class` := "pusher ui stackable grid", ToggleButton()).render
}
