package com.github.kelebra.uber.stream.elements.streams

trait OptimalResize {

  def optimalSizeIn(windowWidth: Int,
                    windowHeight: Int,
                    numberOfElements: Int): (Int, Int) = {
    (1 to numberOfElements)
      ./:((0, 0)) {
        case ((width, height), elementsPerRow) =>
          val numberOfRows = math.ceil(numberOfElements.toDouble / elementsPerRow).toInt
          val (widthCandidate, heightCandidate) = (windowWidth / elementsPerRow, windowHeight / numberOfRows)

          val (adjustedWidth, adjustedHeight) =
            if ((widthCandidate * 9 / 16) < heightCandidate) (widthCandidate, widthCandidate * 9 / 16)
            else (heightCandidate * 16 / 9, heightCandidate)

          if (widthCandidate > width) (adjustedWidth, adjustedHeight)
          else (width, height)
      }
  }
}