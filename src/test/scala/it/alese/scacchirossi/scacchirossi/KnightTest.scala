package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class KnightTest extends WordSpec with Matchers {
  "A knight" should {
    val knight = Knight(WHITE)
    "allow a forward L-shaped move" in {
      knight.isLegalMove(
        Move(Position("A1"), Position("B3"))
      ) shouldBe true
    }
    "allow a backwards L-shaped move" in {
      knight.isLegalMove(
        Move(Position("B3"), Position("A1"))
      ) shouldBe true
    }
  }

  it should {
    val knight = Knight(WHITE)
    "not allow a horizontal move" in {
      knight.isLegalMove(
        Move(Position("A1"), Position("H1"))
      ) shouldBe false
    }
    "not allow a vertical move" in {
      knight.isLegalMove(
        Move(Position("H1"), Position("H8"))
      ) shouldBe false
    }
    "not allow a diagonal move" in {
      knight.isLegalMove(
        Move(Position("A1"), Position("H8"))
      ) shouldBe false
    }
  }
}
