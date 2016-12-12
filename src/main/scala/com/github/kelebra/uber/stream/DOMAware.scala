package com.github.kelebra.uber.stream

import org.scalajs.dom.html.Element
import org.scalajs.dom.{Node, document}

import scalatags.JsDom.all._

trait DOMAware {

  def replaceBodyWith(elements: Node*): Unit = {
    document.body.innerHTML = ""
    elements.foreach(document.body.appendChild)
  }

  def appendToBody(elements: Node*): Unit = elements.foreach(document.body.appendChild)

  def removeFromBody(elements: Element*): Unit = elements.foreach(_.outerHTML = "")

  def exists(id: String): Boolean = document.getElementById(id) != null

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
