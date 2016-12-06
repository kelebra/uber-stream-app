package com.github.kelebra.uber.stream.elements.sidebar

import org.scalajs.dom.MouseEvent

import scala.scalajs.js
import scalatags.JsDom.all._

object ToggleButton {

  def apply() = div(
    `class` := "row",
    div(`class` := "fourteen wide column"),
    div(`class` := "center aligned two wide column",
      button(
        id := "toggle-menu-button",
        `class` := "circular ui icon button",
        i(`class` := "icon settings"),
        onclick := toggleSidebars
      )
    )
  )

  private val toggleSidebars: MouseEvent => Unit = event => {
    js.eval("$('.sidebar').sidebar('toggle');")
    js.eval("$('body').removeClass('pushable');")
  }
}
