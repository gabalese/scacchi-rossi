package it.alese.ScacchiRossi

import org.scalatest.{Matchers, FlatSpec}

class PositionTest extends FlatSpec with Matchers {

  "Position" should "convert from Chessboard coordinates to Board coordinates" in {
    val coordinates = new Position('A', 1)
    coordinates.getX shouldEqual 0
    coordinates.getY shouldEqual 0
  }

  it should "not accept illegal arguments for X" in {
    a [java.lang.IllegalArgumentException] should be thrownBy {
      new Position('M', 1)
    }
  }

  it should "correctly test for equality" in {
    val onePosition = new Position('A', 1)
    val twoPosition = new Position('A', 1)
    val threePosition = new Position('B', 2)

    onePosition shouldEqual twoPosition
    onePosition should not equal threePosition
  }

}
