package it.alese.scacchirossi.scacchirossi

import org.scalatest.{WordSpec, Matchers}

class BishopTest extends WordSpec with Matchers {
  "A bishop" should {
    "allow a left-right diagonal" in {
      Bishop(WHITE).isLegalMove(
        Move(Position("A1"), Position("H8"))
      ) shouldBe true
    }

    "allow a right-left diagonal" in {
      Bishop(WHITE).isLegalMove(
        Move(Position("H1"), Position("A8"))
      ) shouldBe true
    }

    "allow a negative left-right diagonal" in {
      Bishop(WHITE).isLegalMove(
        Move(Position("A8"), Position("H1"))
      ) shouldBe true
    }

    "allow a negative right-left diagonal" in {
      Bishop(WHITE).isLegalMove(
        Move(Position("H8"), Position("A1"))
      ) shouldBe true
    }

    "disallow a horizontal move" in {
      Bishop(WHITE).isLegalMove(
        Move(Position("A1"), Position("H1"))
      ) shouldBe false
    }
  }
}
