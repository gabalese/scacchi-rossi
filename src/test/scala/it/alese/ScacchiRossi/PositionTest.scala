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

  it should "not accept illegal arguments for Y" in {
    a [java.lang.IllegalArgumentException] should be thrownBy {
      new Position('A', 9)
    }
  }

  it should "correctly test for equality" in {
    val onePosition = new Position('A', 1)
    val twoPosition = new Position('A', 1)
    val threePosition = new Position('B', 2)

    onePosition shouldEqual twoPosition
    onePosition should not equal threePosition
  }

  it should "not be equal to something which is not a position" in {
    val position = new Position('A', 1)
    val string = new String()
    position should not equal string
  }

  it should "test equal if initialized with lowercase letter" in {
    val lowerPosition = new Position('a', 1)
    val upperPosition = new Position('A', 1)

    lowerPosition shouldEqual upperPosition
  }

}
