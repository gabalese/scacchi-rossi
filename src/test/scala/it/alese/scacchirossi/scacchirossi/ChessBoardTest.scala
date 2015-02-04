package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}
import org.scalatest.{Matchers, WordSpec}

class ChessBoardTest extends WordSpec with Matchers {
  val chessboard = new ChessBoard().start()

  "A chessboard object" should {
    "contain only valid positions" in {
      val chessboardObject = ChessBoard
      chessboardObject.validPositions should contain(Position("A1"))
      chessboardObject.validPositions should contain(Position("H8"))
    }
  }

  "A chessboard" should {
    "support 64 different positions" in {
      1 to 8 foreach {
        row => 'A' to 'H' foreach {
          col => chessboard.board.contains(Position(Column(col), Row(row))) shouldBe true
        }
      }
    }

    "be in initial state" in {
      chessboard.isFirstMove shouldBe true
    }

    "begin with correct starting positions" in {
      'A' to 'H' foreach {
        col =>
          chessboard.board(Position(Column(col), Row(1))).get.colour shouldBe WHITE
          chessboard.board(Position(Column(col), Row(2))).get.colour shouldBe WHITE
          chessboard.board(Position(Column(col), Row(3))) shouldBe 'empty
          chessboard.board(Position(Column(col), Row(4))) shouldBe 'empty
          chessboard.board(Position(Column(col), Row(5))) shouldBe 'empty
          chessboard.board(Position(Column(col), Row(6))) shouldBe 'empty
          chessboard.board(Position(Column(col), Row(7))).get.colour shouldBe BLACK
          chessboard.board(Position(Column(col), Row(8))).get.colour shouldBe BLACK
      }
    }

    "move a piece from position A to position B" in {
      val positionA = Position("D2")
      val positionB = Position("D3")

      val pawn = chessboard.board(positionA)

      chessboard.move(Move(positionA, positionB))

      chessboard.board(positionA) shouldBe 'empty
      chessboard.board(positionB) shouldBe pawn
    }

    "not be in initial state after a move" in {
      chessboard.isFirstMove shouldBe false
    }

    "add moves to the moves list" in {
      chessboard.moves.length shouldEqual 1
    }

    "not move a piece outside the board" in {
      a[IllegalArgumentException] should be thrownBy {
        chessboard.move(Move(Position("E1"), Position("Q9")))
      }
    }

    "be empty by default" in {
      val emptyBoard = new ChessBoard()
      emptyBoard.board.foreach {
        case (position, piece) => piece should not be 'defined
      }
    }

    "not move a piece beyond another one unless it's a knight" in {
      pending
    }

    "move a piece beyond another one if it's a knight" in {
      pending
    }
  }
}
