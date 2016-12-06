package com.github.kelebra.uber.stream.elements.sidebar

import scalatags.JsDom.all._

object StreamSourceSelection {

  def apply() = div(
    id := "stream-source-selection",
    `class` := "ui top sidebar inverted horizontal labeled icon menu",
    a(`class` := "item", i(`class` := "plus icon"), "New:"),
    a(`class` := "item", i(`class` := "twitch icon"), "Twitch stream")
  ).render
}
