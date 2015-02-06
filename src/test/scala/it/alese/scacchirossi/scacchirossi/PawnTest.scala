package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class PawnTest extends WordSpec with Matchers {
  "A pawn" should {
    val pawn = Pawn(WHITE)

    "move one position forward" in {
      pawn.isLegalMove(
        Move(Position("B2"), Position("B3"))
      ) shouldBe true
    }

    "move one position NW (-1, 1)" in {
      pawn.isLegalMove(
        Move(Position("B2"), Position("A3"))
      ) shouldBe true
    }

    "move one position NE (1, 1)" in {
      pawn.isLegalMove(
        Move(Position("B2"), Position("C3"))
      ) shouldBe true
    }

    "allow a two position forward move" in {
      pawn.isLegalMove(
        Move(Position("A2"), Position("A4"))
      ) shouldBe true
    }
  }

  it should {
    val pawn = Pawn(WHITE)

    "not move more than one position NW" in {
      pawn.isLegalMove(
        Move(Position("B2"), Position("D4"))
      ) shouldBe false
    }

    "not move more than one position NE" in {
      pawn.isLegalMove(
        Move(Position("C2"), Position("A4"))
      ) shouldBe false
    }

    "not move more than two position forward" in {
      pawn.isLegalMove(
        Move(Position("A2"), Position("A5"))
      ) shouldBe false
    }
  }

}
