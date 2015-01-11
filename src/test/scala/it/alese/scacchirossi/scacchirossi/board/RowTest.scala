package it.alese.scacchirossi.scacchirossi.board

import org.scalatest.{Matchers, WordSpec}

class RowTest extends WordSpec with Matchers {

  "A row" should {
    "not be valid with an index not included between 1 and 8" in {
      an [IllegalArgumentException] shouldBe thrownBy {
        Row(9)
      }
    }
    "be valid if an index is in range 1-8" in {
      noException shouldBe thrownBy {
        Row(1)
        Row(8)
      }
    }
  }
}
