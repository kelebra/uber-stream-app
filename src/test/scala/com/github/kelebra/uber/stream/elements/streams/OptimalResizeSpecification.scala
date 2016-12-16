package com.github.kelebra.uber.stream.elements.streams

import utest._

object OptimalResizeSpecification extends TestSuite with OptimalResize{

  val tests = TestSuite{

    "should return optimal size for width: 1412, height: 656, streams: 3" - {
      optimalSizeIn(1412, 656, 3) ==> (583, 328)
    }

    "should return optimal size for width: 1412, height: 656, streams: 4" - {
      optimalSizeIn(1412, 656, 4) ==> (583, 328)
    }

    "should return optimal size for width: 1412, height: 656, streams: 1" - {
      optimalSizeIn(1412, 656, 1) ==> (1166, 656)
    }
  }
}
