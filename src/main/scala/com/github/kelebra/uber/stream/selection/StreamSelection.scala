package com.github.kelebra.uber.stream.selection

import com.github.kelebra.uber.stream.DOMAware
import com.github.kelebra.uber.stream.common.Source
import com.github.kelebra.uber.stream.elements.streams.Content
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.html.Input

import scalatags.JsDom.all._

object StreamSelection extends DOMAware {

  def apply(source: Source): Unit = {
    createModalFor(source)
    openModal(selectionIdOf(source))
  }

  def selectionIdOf(source: Source): String = s"stream-selection-${source.name}"

  def createChannelInput() =
    input(`type` := "text", placeholder := "wagamamatv", style := "color: white").render

  def modal(source: Source) = {
    val channelInput = createChannelInput()
    div(
      id := selectionIdOf(source),
      `class` := "ui basic modal",
      div(`class` := "image content",
        div(`class` := "image", i(`class` := s"${source.icon} icon")),
        div(`class` := "description",
          p("Type channel name below:"),
          p(
            div(`class` := "ui labelled transparent input",
              div(`class` := "ui label", i(`class` := "tv icon")),
              channelInput
            )
          )
        )
      ),
      div(`class` := "actions",
        div(`class` := "two fluid ui inverted buttons",
          div(`class` := "ui ok green basic inverted button", i(`class` := "checkmark icon"),
            onclick := addStream(channelInput, source), "Add"
          ),
          div(`class` := "ui cancel red basic inverted button",
            i(`class` := "remove icon"), "Close"
          )
        )
      )
    )
  }

  private def createModalFor(source: Source): Unit = {
    val selectionModalId = selectionIdOf(source)
    if (!exists(selectionModalId)) appendToBody(modal(source).render)
  }

  private def addStream(channelInput: Input, source: Source): MouseEvent => Unit =
    _ => {
      Content ++(channelInput.value.toLowerCase, source)
      clear(channelInput)
    }

  private def openModal(id: String): Unit =
    scalajs.js.eval(s"$$('#$id').modal('setting', 'closable', false).modal('show')")
}