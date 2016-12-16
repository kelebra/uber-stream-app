package com.github.kelebra.uber.stream

import org.scalajs.dom.html.{Element, Input}
import org.scalajs.dom.{Node, UIEvent, document, window}

import scalatags.JsDom.all._

trait DOMAware {

  def replaceBodyWith(elements: Node*): Unit = {
    document.body.innerHTML = ""
    document.body.style.backgroundColor = "black"
    elements.foreach(document.body.appendChild)
  }

  def appendToBody(elements: Node*): Unit = elements.foreach(document.body.appendChild)

  def removeFromBody(elements: Element*): Unit = elements.foreach(_.outerHTML = "")

  def exists(id: String): Boolean = document.getElementById(id) != null

  def clear(input: Input): Unit = input.value = ""

  def windowWidth = document.body.offsetWidth.toInt

  def windowHeight = document.body.offsetHeight.toInt

  def onResize(f: () => Unit): Unit = {
    val handler: UIEvent => Unit = _ => f()
    window.onresize = handler
  }

  private def addToHead(element: Node): Unit = document.head.appendChild(element)

  def metaInfo(): Unit = addToHead(
    meta(
      charset := "utf-8",
      httpEquiv := "X-UA-Compatible",
      name := "viewport",
      content := "IE=edge, chrome=1, width=device-width, initial-scale=1.0, maximum-scale=1.0"
    ).render
  )

  def css(url: String): Unit = addToHead(link(rel := "stylesheet", `type` := "text/css", href := url).render)

  def js(url: String): Unit = addToHead(script(`type` := "text/javascript", src := url).render)
}
