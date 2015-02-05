package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}
import org.scalatest.{Matchers, WordSpec}

class PositionTest extends WordSpec with Matchers {

  "A position" should {
    "support a campanion object syntax" in {
      val position = Position("A1")
      position shouldEqual new Position(Column('A'), Row(1))
    }

    "return its x axis" in {
      val position = Position("A1")
      position.x shouldBe 1
    }

    "return its y axis" in {
      val position = Position("A1")
      position.y shouldBe 1
    }

    "return its x axis if not equal 0" in {
      val position = Position("B1")
      position.x shouldEqual 2
      position.y shouldEqual 1
    }

    "return 8,1 for H1 position" in {
      val position = Position("H1")
      position.x shouldEqual 8
      position.y shouldEqual 1
    }

    "return a new position with sum operator" in {
      Position("A1") + (1,1) shouldEqual Position("B2")
      Position("A1") + (0,1) shouldEqual Position("A2")
    }

    "return a new position summed to negative coordinates" in {
      Position("C3") + (-1, -1) shouldEqual Position("B2")
    }

    "return same position if zero is passed" in {
      Position("C3") + (0, 0) shouldEqual Position("C3")
    }

    "return a range of contiguous vertical positions" in {
      Position("A1") to Position("A4") shouldEqual List(Position("A1"), Position("A2"), Position("A3"), Position("A4"))
    }

    "return a range of contiguous horizontal positions" in {
      Position("C1") to Position("G1") shouldEqual List(Position("C1"), Position("D1"), Position("E1"), Position("F1"), Position("G1"))
    }

    "return a range of diagonal positions" in {
      Position("A1") to Position("C3") shouldEqual List(Position("A1"), Position("B2"), Position("C3"))
    }

    "return a range of diagonal positions if negative" in {
      Position("C3") to Position("A1") shouldEqual List(Position("C3"), Position("B2"), Position("A1"))
    }

    "return a range for a L-shaped move" in {
      Position("A1") to Position("B3") shouldEqual List(Position("A1"), Position("A2"), Position("A3"), Position("B3"))
    }

    "return a range for a negative L-shaped move" in {
      Position("B3") to Position("A1") shouldEqual List(Position("B3"), Position("B2"), Position("B1"), Position("A1"))
    }

    "raise an exception for illegal argument string" in {
      an [IllegalArgumentException] shouldBe thrownBy {
        Position("AA1")
      }
    }

    "return a list of positions between self and position" in {
      Position("A1") to Position("A3") shouldEqual List(Position("A1"), Position("A2"), Position("A3"))
    }
  }
}
