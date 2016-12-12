package com.github.kelebra.uber.stream.common

sealed case class Source(name: String, icon: String, url: String) {

  def `rendered url`(channel: String) = s"$url$channel"
}

object Twitch extends Source("Twitch", "twitch", "http://player.twitch.tv/?channel=")
