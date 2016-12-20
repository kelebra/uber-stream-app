package com.github.kelebra.uber.stream.elements.sidebar

import org.scalajs.dom.html.Element

import scalatags.JsDom.all._

object StreamControl {

  val controlPanel = div(id := "stream-controls", `class` := "ui bottom sidebar inverted horizontal menu").render

  def apply() = controlPanel

  def append(control: Element): Unit = controlPanel.appendChild(control)
}
