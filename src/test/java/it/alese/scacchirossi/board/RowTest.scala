package it.alese.scacchirossi.board

import org.scalatest.{Matchers, WordSpec}

class RowTest extends WordSpec with Matchers {

  "A row" should {
    "not be valid with an index not included between 1 and 8" in {

      a[IllegalArgumentException] shouldBe thrownBy {
        Row(9)
      }

    }
  }
}
