package com.github.kelebra.uber.stream.elements.sidebar

import com.github.kelebra.uber.stream.common.Source
import com.github.kelebra.uber.stream.selection.StreamSelection
import org.scalajs.dom.MouseEvent

import scalatags.JsDom.all._

object StreamSourceSelection {

  def apply(sources: Source*) = {
    val menu = div(
      id := "stream-source-selection",
      `class` := "ui top sidebar inverted horizontal labeled icon menu"
    ).render
    sources.map(createSourceMenuItem).foreach(menu.appendChild)
    menu
  }

  private def createSourceMenuItem(source: Source) = a(
    `class` := "item",
    i(`class` := s"${source.icon} icon"),
    s"${source.name} stream",
    onclick := selectStream(source)
  ).render

  private def selectStream(source: Source): MouseEvent => Unit = _ => StreamSelection(source)
}
