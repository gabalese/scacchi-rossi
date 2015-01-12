package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}
import scala.collection.mutable

class ChessBoard {
  type Board = mutable.Map[Position, Option[Piece]]

  val board: Board = mutable.Map(Column.validColumns.flatMap(col => Row.validRows map ( row => Position(col, row) -> None )) :_*)

  // *** Place Pawns
  Column.validColumns.foreach {
    col => board.put(Position(col, Row(2)), Some(new Pawn(WHITE)))
  }
  Column.validColumns.foreach {
    col => board.put(Position(col, Row(7)), Some(new Pawn(BLACK)))
  }

  // *** Place Rookies
  board.put(Position("A1"), Some(new Rookie(WHITE)))
  board.put(Position("H1"), Some(new Rookie(WHITE)))
  board.put(Position("A8"), Some(new Rookie(BLACK)))
  board.put(Position("H8"), Some(new Rookie(BLACK)))

  // *** Place Horses
  board.put(Position("B1"), Some(new Horse(WHITE)))
  board.put(Position("G1"), Some(new Horse(WHITE)))
  board.put(Position("B8"), Some(new Horse(BLACK)))
  board.put(Position("G8"), Some(new Horse(BLACK)))

  // *** Place Bishops
  board.put(Position("C1"), Some(new Bishop(WHITE)))
  board.put(Position("F1"), Some(new Bishop(WHITE)))
  board.put(Position("C8"), Some(new Bishop(BLACK)))
  board.put(Position("F8"), Some(new Bishop(BLACK)))

  // *** Place Queens
  board.put(Position("D1"), Some(new Queen(WHITE)))
  board.put(Position("D8"), Some(new Queen(BLACK)))

  // *** Place Kings
  board.put(Position("E1"), Some(new King(WHITE)))
  board.put(Position("E8"), Some(new King(BLACK)))

  def move(move: Move) = {
    board(move.from) match {
      case Some(piece) =>
        board(move.from) = None
        board.put(move.to, Some(piece))
      case None => throw new Exception(s"Empty position ${move.from}")
    }
  }

}
