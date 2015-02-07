package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}

import scala.collection.mutable

class ChessBoard {
  type Board = mutable.Map[Position, Option[Piece]]

  private val board: Board = mutable.Map(Column.validColumns.flatMap(col => Row.validRows map (row => Position(col, row) -> None)): _*)
  private val moves = mutable.ListBuffer[Move]()

  def start(): ChessBoard = {
    // *** Place Pawns
    Column.validColumns.foreach {
      col => board.put(Position(col, Row(2)), Some(Pawn(WHITE)))
    }
    Column.validColumns.foreach {
      col => board.put(Position(col, Row(7)), Some(Pawn(BLACK)))
    }

    // *** Place Rooks
    board.put(Position("A1"), Some(Rook(WHITE)))
    board.put(Position("H1"), Some(Rook(WHITE)))
    board.put(Position("A8"), Some(Rook(BLACK)))
    board.put(Position("H8"), Some(Rook(BLACK)))

    // *** Place Knights
    board.put(Position("B1"), Some(Knight(WHITE)))
    board.put(Position("G1"), Some(Knight(WHITE)))
    board.put(Position("B8"), Some(Knight(BLACK)))
    board.put(Position("G8"), Some(Knight(BLACK)))

    // *** Place Bishops
    board.put(Position("C1"), Some(Bishop(WHITE)))
    board.put(Position("F1"), Some(Bishop(WHITE)))
    board.put(Position("C8"), Some(Bishop(BLACK)))
    board.put(Position("F8"), Some(Bishop(BLACK)))

    // *** Place Queens
    board.put(Position("D1"), Some(Queen(WHITE)))
    board.put(Position("D8"), Some(Queen(BLACK)))

    // *** Place Kings
    board.put(Position("E1"), Some(King(WHITE)))
    board.put(Position("E8"), Some(King(BLACK)))
    this
  }

  def get(position: Position): Option[Piece] = {
    board(position)
  }

  def put(position: Position, piece: Piece) = {
    board.put(position, Some(piece))
  }

  def place(piece: Piece, position: Position): Boolean = {
    this.get(position) match {
      case Some(existingPiece) => false
      case None =>
        board.put(position, Some(piece))
        true
    }
  }

  def move(move: Move): Either[java.lang.Throwable, Position] = {
    board(move.from) match {
      case Some(piece) =>
        board(move.from) = None
        board.put(move.to, Some(piece))
        moves += move
          Right(move.to)
      case None => Left(new Exception(s"Empty position ${move.from}"))
    }
  }

  def isFirstMove = moves.isEmpty

  def completedMoves = moves.toList

}

object ChessBoard {
  val validPositions = Column.validColumns.flatMap(col => Row.validRows.map(row => Position(col, row)))
}
