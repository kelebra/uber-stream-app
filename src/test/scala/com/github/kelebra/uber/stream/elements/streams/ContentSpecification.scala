package com.github.kelebra.uber.stream.elements.streams

import com.github.kelebra.uber.stream.App
import com.github.kelebra.uber.stream.common.Twitch
import utest._

object ContentSpecification extends TestSuite {

  App.main()
  Content.empty()

  val tests = TestSuite {

    "should add displays element when added" - {
      val previous = Content.count
      Content ++("some channel", Twitch)
      assert(previous < Content.count)
    }

    "should remove displays element when deleted" - {
      Content ++("some channel", Twitch)
      Content ++("another channel", Twitch)
      Content -("another channel", Twitch)
      Content.count ==> 2
    }
  }
}
