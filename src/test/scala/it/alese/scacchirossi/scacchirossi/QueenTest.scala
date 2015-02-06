package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class QueenTest extends WordSpec with Matchers {
  "A Queen" should {
    val queen = Queen(WHITE)

    "allow a move in horizontal" in {
      queen.isLegalMove(
        Move(Position("A1"), Position("H1"))
      ) shouldBe true
    }

    "allow a move in vertical" in {
      queen.isLegalMove(
        Move(Position("H1"), Position("H8"))
      ) shouldBe true
    }

    "allow a left-right diagonal" in {
      queen.isLegalMove(
        Move(Position("A1"), Position("H8"))
      ) shouldBe true
    }

    "allow a right-left diagonal" in {
      queen.isLegalMove(
        Move(Position("H1"), Position("A8"))
      ) shouldBe true
    }

    "allow a negative left-right diagonal" in {
      queen.isLegalMove(
        Move(Position("A8"), Position("H1"))
      ) shouldBe true
    }

    "allow a negative right-left diagonal" in {
      queen.isLegalMove(
        Move(Position("H8"), Position("A1"))
      ) shouldBe true
    }
  }

  it should {
    val queen = Queen(WHITE)
    "not allow a forward L-shaped move" in {
      queen.isLegalMove(
        Move(Position("A1"), Position("B3"))
      ) shouldBe false
    }

    "not allow a backwards L-shaped move" in {
      queen.isLegalMove(
        Move(Position("B3"), Position("A1"))
      ) shouldBe false
    }
  }
}
