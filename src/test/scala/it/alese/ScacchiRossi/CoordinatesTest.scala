package it.alese.ScacchiRossi

import org.scalatest.{Matchers, FlatSpec}

class CoordinatesTest extends FlatSpec with Matchers {

  "ChessCoordinates" should "convert from Chessboard coordinates to Board coordinates" in {
    val coordinates = new ChessCoordinates('A', 1)
    coordinates.getX shouldEqual 0
    coordinates.getY shouldEqual 0
  }

  it should "not accept illegal arguments for X" in {
    a [java.lang.IllegalArgumentException] should be thrownBy {
      new ChessCoordinates('M', 1)
    }
  }

}
