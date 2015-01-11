package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}
import org.scalatest.{Matchers, WordSpec}

class PositionTest extends WordSpec with Matchers {

  "A position" should {
    "support a campanion object syntax" in {
      val position = Position("A1")
      position shouldEqual new Position(Column('A'), Row(1))
    }

    "return its x axis, zero-based" in {
      val position = Position("A1")
      position.x shouldBe 0
    }

    "return its y axis, zero-based" in {
      val position = Position("A1")
      position.y shouldBe 0
    }

    "return its x axis if not equal 0" in {
      val position = Position("B1")
      position.x shouldEqual 1
      position.y shouldEqual 0
    }

    "raise an exception for illegal argument string" in {
      an [IllegalArgumentException] shouldBe thrownBy {
        Position("AA1")
      }
    }
  }
}
