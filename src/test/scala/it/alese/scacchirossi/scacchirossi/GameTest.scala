package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class GameTest extends WordSpec with Matchers {
  "A game" should {
    val game = Game.start()
    "be initialized with pieces in place" in {
      game.chessboard(Position("H1")) shouldEqual Rook(WHITE)
    }
    "support a move" in {
      val move = Move(Position("A2"), Position("A3"))
      val gameAfterMove = game.move(move)
      gameAfterMove shouldBe a[Game]
      gameAfterMove.chessboard.get(Position("A3")) shouldEqual Some(Pawn(WHITE))
      gameAfterMove.chessboard.get(Position("A2")) shouldBe None
      gameAfterMove.moves shouldEqual List(move)
    }
  }
}
