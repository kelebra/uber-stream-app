package com.github.kelebra.uber.stream

import com.github.kelebra.uber.stream.common.Twitch
import com.github.kelebra.uber.stream.elements.sidebar.{StreamControl, StreamSourceSelection}
import com.github.kelebra.uber.stream.elements.streams.Content

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

object App extends js.JSApp with DOMAware {

  def defineHead(): Unit = {
    metaInfo()

    js("https://code.jquery.com/jquery-3.1.0.min.js")

    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/reset.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/site.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/container.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/grid.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/header.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/image.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/menu.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/divider.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/dropdown.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/segment.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/button.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/list.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/icon.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/sidebar.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/transition.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/card.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/statistic.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/dimmer.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/modal.min.css")
    css("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/input.min.css")

    js("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/visibility.min.js")
    js("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/sidebar.min.js")
    js("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/transition.min.js")
    js("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/dimmer.min.js")
    js("https://cdn.jsdelivr.net/semantic-ui/2.2.2/components/modal.min.js")
  }

  @JSExport
  override def main(): Unit = {
    defineHead()
    replaceBodyWith(Content.empty(), StreamSourceSelection(Twitch), StreamControl())
  }
}
