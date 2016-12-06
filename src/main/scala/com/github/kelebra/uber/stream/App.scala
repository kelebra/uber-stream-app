package com.github.kelebra.uber.stream

import com.github.kelebra.uber.stream.elements.Content
import com.github.kelebra.uber.stream.elements.sidebar.StreamSourceSelection

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

object App extends js.JSApp with UI {

  @JSExport
  override def main(): Unit = replaceBodyWith(
    Content(),
    StreamSourceSelection()
  )
}
