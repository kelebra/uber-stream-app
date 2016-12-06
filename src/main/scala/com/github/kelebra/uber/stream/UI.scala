package com.github.kelebra.uber.stream

import org.scalajs.dom.{Node, document}

trait UI {

  def replaceBodyWith(elements: Node*): Unit = {
    document.body.innerHTML = ""
    elements.foreach(document.body.appendChild)
  }
}
