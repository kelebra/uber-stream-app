package com.github.kelebra.uber.stream.elements.streams

import com.github.kelebra.uber.stream.DOMAware
import com.github.kelebra.uber.stream.common.Source
import com.github.kelebra.uber.stream.elements.sidebar.ToggleButton

import scala.collection.mutable
import scalatags.JsDom.all._

object Content extends DOMAware with OptimalResize {

  onResize(~><~)

  private val displays = mutable.ArrayBuffer.empty[StreamDisplay]

  def ++(channel: String, source: Source): Unit = {
    val display = StreamDisplay(source = source, `channel name` = channel)
    displays += display
    display.show()
    ~><~()
  }

  def -(channel: String, source: Source): Unit = {
    displays.zipWithIndex
      .filter(_._1.`channel name` == channel)
      .filter(_._1.source == source)
      .foreach { case (_, index) => displays.remove(index) }
    ~><~()
  }

  def ~><~(): Unit = {
    val (width, height) = optimalSizeIn(windowWidth, windowHeight, count)
    displays.foreach(_.resize(width, height))
  }

  def count = displays.size

  def empty() = div(`class` := "pusher ui stackable grid", ToggleButton()).render
}
