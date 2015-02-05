package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}
import org.scalatest.{Matchers, WordSpec}

class MoveTest extends WordSpec with Matchers {
  "A move" should {
    val start = Position("A1")
    val stop = Position("B2")

    "express a tuple of distance" in {
      val move = Move(start, stop)
      move.distance shouldEqual (1, 1)
    }

    "be capable of expressing a negative distance" in {
      val move = Move(stop, start)
      move.distance shouldEqual (-1, -1)
    }

    "not have an illegal from" in {
      a[IllegalArgumentException] shouldBe thrownBy {
        Move(Position(Column('H'), Row(9)), Position(Column('A'), Row(1)))
      }
    }
    "not have an illegal to" in {
      a[IllegalArgumentException] shouldBe thrownBy {
        Move(Position(Column('A'), Row(1)), Position(Column('H'), Row(9)))
      }
    }

    "return a zero vertical distance for a horizontal move" in {
      Move(Position("A1"), Position("H1")).distance should equal (7, 0)
      Move(Position("H1"), Position("A1")).distance should equal (-7, 0)
    }

    "return a zero horizontal distance for a vertical move" in {
      Move(Position("A1"), Position("A8")).distance should equal (0, 7)
      Move(Position("A8"), Position("A1")).distance should equal (0, -7)
    }

    "return (7,7) for a right diagonal" in {
      Move(Position("A1"), Position("H8")).distance should equal (7, 7)
    }

    "return (-7,7) for a left diagonal" in {
      Move(Position("H1"), Position("A8")).distance should equal (-7, 7)
    }
  }
}
