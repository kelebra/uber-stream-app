package com.github.kelebra.uber.stream.common

sealed case class Source(name: String, icon: String, url: String, defaultChannel: String) {

  def `rendered url`(channel: String) = s"$url$channel"
}

object Twitch extends Source("Twitch", "twitch", "https://player.twitch.tv/?channel=", "dreadztv")

object Hitbox extends Source("Hitbox", "inbox", "https://hitbox.tv/#!/embed/", "wellplay")

object YouTube extends Source("Youtube", "youtube",
  "https://www.youtube.com/embed/?listType=user_uploads&list=", "MajorLeagueGaming")