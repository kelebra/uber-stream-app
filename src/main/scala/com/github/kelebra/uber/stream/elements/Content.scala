package com.github.kelebra.uber.stream.elements

import com.github.kelebra.uber.stream.elements.sidebar.ToggleButton

import scalatags.JsDom.all._

object Content {

  def apply() = div(`class` := "pusher ui stackable grid", ToggleButton()).render
}
