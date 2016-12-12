package com.github.kelebra.uber.stream.elements.streams

import com.github.kelebra.uber.stream.common.Source
import com.github.kelebra.uber.stream.elements.sidebar.ToggleButton

import scala.collection.mutable
import scalatags.JsDom.all._

object Content {

  private val displays = mutable.Set.empty[StreamDisplay]

  def ++(channel: String, source: Source): Unit = {
    val display = StreamDisplay(source = source, `channel name` = channel)
    displays += display
    display.element.render
  }

  def -(channel: String, source: Source): Unit = {
    val toDelete = displays.filter(_.`channel name` == channel).filter(_.source == source)
    toDelete.foreach(displays.remove)
    toDelete.foreach(_.delete())
  }

  def count = displays.size

  def empty() = div(`class` := "pusher ui stackable grid", ToggleButton()).render
}
