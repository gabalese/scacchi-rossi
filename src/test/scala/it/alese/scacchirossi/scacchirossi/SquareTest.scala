package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class SquareTest extends WordSpec with Matchers {

  "A square" should {
    "report empty when no piece is present" in {
      Square(None, None).isEmpty shouldBe true
    }

    "report available when empty or just one piece" in {
      Square(Some(Rook(WHITE)), None).isAvailable shouldBe true
      Square(None, Some(King(BLACK))).isAvailable shouldBe true
      Square(None, None).isAvailable shouldBe true
    }

    "report not available when two pieces are present" in {
      Square(Some(Rook(WHITE)), Some(Bishop(BLACK))).isAvailable shouldBe false
    }

     "not add two whites in the same place" in {
      Square(Some(Rook(WHITE)), None).put(King(WHITE)) shouldBe 'left
    }

    "not add two blacks in the same place" in {
      Square(None, Some(Bishop(BLACK))).put(King(BLACK)) shouldBe 'left
    }

    "add one piece" in {
      Square(None, None).put(Rook(BLACK)) shouldBe Right(Square(None, Some(Rook(BLACK))))
    }

    "report that contains white if contains white" in {
      Square(Some(Rook(WHITE)), Some(King(BLACK))).hasColour(BLACK) shouldBe true
    }
  }

}
