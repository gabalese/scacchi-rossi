package it.alese.scacchirossi.scacchirossi.board

import org.scalatest.{WordSpec, Matchers}

class Column$Test extends WordSpec with Matchers {

  "A column" should {
    "not be initialized with a letter beyond the range A-H" in {
      an [IllegalArgumentException] shouldBe thrownBy {
        Column('J')
      }
    }
    "be initialized with a letter in range" in {
      noException shouldBe thrownBy {
        Column('H')
        Column('A')
      }
    }
  }
}
