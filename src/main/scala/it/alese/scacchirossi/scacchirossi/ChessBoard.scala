package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}
import scala.collection.mutable
import scala.util.Try

class ChessBoard {

  val board: mutable.Map[Position, Option[Piece]] =
    mutable.Map(Column.validColumns.flatMap(col => Row.validRows map ( row => Position(col, row) -> None )) :_*)

  Column.validColumns.foreach {
    col => board.put(Position(col, Row(2)), Some(new Pawn(WHITE)))
  }

  Column.validColumns.foreach {
    col => board.put(Position(col, Row(7)), Some(new Pawn(BLACK)))
  }

  board.put(Position(Column('A'), Row(1)), Some(new Rookie(WHITE)))
  board.put(Position(Column('A'), Row(8)), Some(new Rookie(BLACK)))
  board.put(Position(Column('H'), Row(1)), Some(new Rookie(WHITE)))
  board.put(Position(Column('H'), Row(8)), Some(new Rookie(WHITE)))

  def move(move: Move) = Try[Piece] {
    ???
  }

}
