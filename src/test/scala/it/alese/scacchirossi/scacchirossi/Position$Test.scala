package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}
import org.scalatest.{Matchers, WordSpec}

class Position$Test extends WordSpec with Matchers {

  "A position" should {
    "support a campanion object syntax" in {
      val position = Position("A1")
      position shouldBe a [Position]
      position shouldEqual new Position(Column('A'), Row(1))
    }
  }
}
