package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class BishopTest extends WordSpec with Matchers {
  "A bishop" should {
    val bishop = Bishop(WHITE)
    "allow a left-right diagonal" in {
      bishop.isLegalMove(
        Move(Position("A1"), Position("H8"))
      ) shouldBe true
    }

    "allow a right-left diagonal" in {
      bishop.isLegalMove(
        Move(Position("H1"), Position("A8"))
      ) shouldBe true
    }

    "allow a negative left-right diagonal" in {
      bishop.isLegalMove(
        Move(Position("A8"), Position("H1"))
      ) shouldBe true
    }

    "allow a negative right-left diagonal" in {
      bishop.isLegalMove(
        Move(Position("H8"), Position("A1"))
      ) shouldBe true
    }

    "disallow a horizontal move" in {
      bishop.isLegalMove(
        Move(Position("A1"), Position("H1"))
      ) shouldBe false
    }
  }
}
