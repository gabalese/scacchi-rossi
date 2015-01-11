package it.alese.scacchirossi

import it.alese.scacchirossi.board.{Column, Row}
import org.scalatest.{Matchers, WordSpec}

class ChessBoardTest extends WordSpec with Matchers {
  val chessboard = new ChessBoard()

  "A chessboard" should {
    "support 64 different positions" in {
      1 to 8 foreach { row => 'A' to 'H' foreach { col =>
        chessboard.board.contains(Position(Column(col), Row(row))) shouldBe true
      }}
    }
  }
}
