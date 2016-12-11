package com.github.kelebra.uber.stream.elements.streams

import com.github.kelebra.uber.stream.DOMAware
import org.scalajs.dom.html.IFrame

import scalatags.JsDom.all._

sealed case class StreamDisplay(`height in pixels`: Int = 800,
                                `width in pixels`: Int = 600,
                                source: Source,
                                `channel name`: String) extends DOMAware {

  lazy val element: IFrame = {
    val frame = iframe(
      src := source.`rendered url`(`channel name`),
      height := `height in pixels`,
      width := `width in pixels`
    ).render
    appendToBody(frame.render)
    frame
  }

  def delete() = removeFromBody(element)
}

sealed abstract class Source(url: String) {

  def `rendered url`(channel: String) = s"$url$channel"
}

case object Twitch extends Source("http://player.twitch.tv/?channel=")
