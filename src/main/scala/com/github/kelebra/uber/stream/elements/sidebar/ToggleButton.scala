package com.github.kelebra.uber.stream.elements.sidebar

import org.scalajs.dom.MouseEvent

import scala.scalajs.js
import scalatags.JsDom.all._

object ToggleButton {

  def apply() = div(
    `class` := "ui black big launch right attached fixed button",
    style := "display: block; position: fixed; top: 2.5em; left: 0px;",
    i(`class` := "content icon"),
    onclick := toggleSidebars
  )

  private val toggleSidebars: MouseEvent => Unit = event => {
    js.eval("$('.sidebar').sidebar('toggle');")
    js.eval("$('body').removeClass('pushable');")
  }
}
