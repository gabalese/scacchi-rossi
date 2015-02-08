package it.alese.scacchirossi.scacchirossi

import org.scalatest.{Matchers, WordSpec}

class ChessBoardTest extends WordSpec with Matchers {

  "A chessboard object" should {
    "contain only valid positions" in { val chessboardObject = ChessBoard
      chessboardObject.validPositions should contain(Position("A1"))
      chessboardObject.validPositions should contain(Position("H8"))
    }
  }

  "A chessboard" should {
    "report zero moves at first" in { val chessboard = new ChessBoard(Map[Position, Square](), Nil)
      chessboard.isFirstMove shouldBe true
      chessboard.completedMoves shouldBe 'empty
    }
  }

  it should { val chessboard = new ChessBoard(Map[Position, Square](), Nil)
    "be able to put a piece on a empty square" in {
      chessboard.put(Position("A1"), Rook(WHITE)) shouldBe 'right
        chessboard.put(Position("A1"), Rook(WHITE)).fold(l => throw new Exception, r => r)
          .get(Position("A1")) shouldBe Some(Square(Some(Rook(WHITE)), None))
    }
    "be initable" in {
      val fullChessboard = new ChessBoard(Map[Position, Square](), Nil).init()
      fullChessboard.get(Position("A1")) shouldBe 'defined
      fullChessboard.get(Position("C3")) shouldBe 'empty
    }
  }
}
