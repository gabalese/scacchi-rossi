package it.alese.scacchirossi

import it.alese.scacchirossi.Pieces.Pawn
import org.scalatest.{FlatSpec, Matchers}

class ChessBoardTest extends FlatSpec with Matchers {
  val chessboard = new ChessBoard()

  "A chessboard" should "support 64 different positions" in {
    chessboard.board.size shouldEqual 64
  }

  it should "support get operations" in {
    val coordinates = new Position('a', 1)
    chessboard.getSquareAt(coordinates) shouldBe a [Square]
  }

  it should "support putting a piece" in {
    val coordinates = new Position('A', 1)
    val pawn = new Pawn()
    chessboard.setPieceAt(coordinates, pawn)
    chessboard.getSquareAt(coordinates) should not be empty
    chessboard.getSquareAt(coordinates).getPiece shouldBe an [Option[_]]
    chessboard.getSquareAt(coordinates).getPiece.get shouldBe pawn
  }
}
