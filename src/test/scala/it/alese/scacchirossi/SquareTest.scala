package it.alese.scacchirossi

import it.alese.scacchirossi.Pieces.{Rookie, Pawn}
import org.scalatest.{FlatSpec, Matchers}

class SquareTest extends FlatSpec with Matchers {
  val chessboard = new ChessBoard()
  val position = new Position('A', 1)

  "A square" should "be empty when initialized" in {
    val square = chessboard.getSquareAt(position)
    square should be ('empty)
  }

  it should "add a new piece" in {
    val square = chessboard.getSquareAt(position)
    val piece = square.add(new Pawn)
    piece shouldBe a [Pawn]
  }

  it should "not allow a second piece" in {
    val square = chessboard.getSquareAt(position)
    val piece = square.add(new Pawn)
    val secondPiece = square.add(new Rookie)
    secondPiece should not be a [Pawn]
    secondPiece should not be piece
    secondPiece shouldBe a [Rookie]
  }
}
