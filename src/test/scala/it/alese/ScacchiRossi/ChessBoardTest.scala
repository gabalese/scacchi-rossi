package it.alese.ScacchiRossi

import org.scalatest.{FlatSpec, Matchers}

class ChessBoardTest extends FlatSpec with Matchers {
  "A chessboard" should "support 64 different positions" in {
    val chessboard = new ChessBoard()
    chessboard.board.size shouldEqual 64
  }

  it should "support get operations" in {
    val chessboard = new ChessBoard()
    val coordinates = new Position('a', 1)
    chessboard.getSquareAt(coordinates) shouldBe a [Square]
  }
}
