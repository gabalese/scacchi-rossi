package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class GameTest extends WordSpec with Matchers {
  "A game" should {
    val game = Game.start()
    "be initialized with pieces in place" in {
      game.chessboard.board(Position("H1")) shouldEqual Rook(WHITE)
    }
    "support a move" in {
      val gameAfterMove = game.move(Move(Position("A2"), Position("A3")))
      gameAfterMove shouldBe a[Game]
      gameAfterMove.chessboard.board.get(Position("A3")) shouldEqual Some(Pawn(WHITE))
      gameAfterMove.chessboard.board.get(Position("A2")) shouldBe None
    }
  }
}
