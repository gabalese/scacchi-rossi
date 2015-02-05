package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class RookTest extends WordSpec with Matchers {
  "A rook" should {
    "allow a move in horizontal" in {
      Rook(WHITE).canMove(
        Move(Position("A1"), Position("H1"))
      ) shouldBe true
    }

    "allow a move in vertical" in {
      Rook(WHITE).canMove(
        Move(Position("H1"), Position("H8"))
      ) shouldBe true
    }

    "not allow a diagonal move" in {
      Rook(WHITE) canMove Move(Position("A1"), Position("H8")) shouldBe false
    }
  }
}
