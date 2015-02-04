package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}
import org.scalatest.{Matchers, WordSpec}

class MoveTest extends WordSpec with Matchers {
  "A move" should {
    val start = Position("A1")
    val stop = Position("B2")

    "express a tuple of distance" in {
      val move = Move(start, stop)
      move.distance shouldEqual(1, 1)
    }

    "be capable of expressing a negative distance" in {
      val move = Move(stop, start)
      move.distance shouldEqual(-1, -1)
    }

    "not have an illegal from" in {
      a[IllegalArgumentException] shouldBe thrownBy {
        Move(new Position(Column('H'), Row(9)), new Position(Column('A'), Row(1)))
      }
    }
    "not have an illegal to" in {
      a[IllegalArgumentException] shouldBe thrownBy {
        Move(new Position(Column('A'), Row(1)), new Position(Column('H'), Row(9)))
      }
    }
  }
}
