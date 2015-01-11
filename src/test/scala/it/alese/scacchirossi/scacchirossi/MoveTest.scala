package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class MoveTest extends WordSpec with Matchers {
  "A move" should {
    val start = Position("A1")
    val stop = Position("B2")

    "express a tuple of distance" in {
      val move = Move(start, stop)
      move.distance shouldEqual (1,1)
    }

    "be capable of expressing a negative distance" in {
      val move = Move(stop, start)
      move.distance shouldEqual (-1, -1)
    }
  }
}
