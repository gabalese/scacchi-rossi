package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class KingTest extends WordSpec with Matchers {
  "A king" should {
    val king = King(WHITE)
    "move one position forward (0,1)" in {
      king.isLegalMove(
        Move(Position("C1"), Position("C2"))
      ) shouldBe true
    }
    "move one position backward (0, -1)" in {
      king.isLegalMove(
        Move(Position("C2"), Position("C1"))
      ) shouldBe true
    }
    "move one position on the left (-1, 0)" in {
      king.isLegalMove(
        Move(Position("C1"), Position("B1"))
      ) shouldBe true
    }
    "move one position on the right (-1, 0)" in {
      king.isLegalMove(
        Move(Position("C1"), Position("D1"))
      ) shouldBe true
    }
    "move one position north-west (-1, 1)" in {
      king.isLegalMove(
        Move(Position("C1"), Position("B2"))
      ) shouldBe true
    }
    "move one position north-east (1,1)" in {
      king.isLegalMove(
        Move(Position("C1"), Position("D2"))
      ) shouldBe true
    }
    "move one position south-east (-1, -1)" in {
      king.isLegalMove(
        Move(Position("D4"), Position("E3"))
      ) shouldBe true
    }
    "move on position south-west (1, -1)" in {
      king.isLegalMove(
        Move(Position("D4"), Position("C3"))
      ) shouldBe true

    }
  }

  it should {
    val king = King(WHITE)
    "not move more than one position forward" in {
      king.isLegalMove(
        Move(Position("C1"), Position("C3"))
      ) shouldBe false
    }
    "not move more than one position backward" in {
      king.isLegalMove(
        Move(Position("C3"), Position("C1"))
      ) shouldBe false
    }
    "not move one left and two up (1, 2)" in {
      king.isLegalMove(
        Move(Position("D4"), Position("E6"))
      ) shouldBe false
    }
  }
}
