package com.github.kelebra.uber.stream.elements.streams

import org.scalajs.dom.Element

import scalatags.JsDom.all._

sealed case class StreamDisplay(`height in pixels`: Int,
                                `width in pixels`: Int,
                                `type`: StreamType,
                                `channel name`: String
                               ) {

  lazy val element: Element = iframe(
    src := `type`.`rendered url`(`channel name`),
    height := `height in pixels`,
    width := `width in pixels`
  ).render
}

sealed abstract class StreamType(url: String) {

  def `rendered url`(channel: String) = s"$url$channel"
}

case object Twitch extends StreamType("http://player.twitch.tv/?channel=")
