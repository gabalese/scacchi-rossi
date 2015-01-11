package it.alese.scacchirossi

import it.alese.scacchirossi.board.{Column, Row}
import scala.collection.mutable
import scala.util.Try

class ChessBoard {

  val board: mutable.Map[Position, Option[Piece]] =
    mutable.Map(Column.validColumns.flatMap(col => Row.validRows map ( row => Position(col, row) -> None )) :_*)

  // Init pieces on board
  Column.validColumns.foreach {
    col => board.put(Position(col, Row(2)), Some(new Pawn(WHITE)))
  }

  Column.validColumns.foreach {
    col => board.put(Position(col, Row(7)), Some(new Pawn(BLACK)))
  }

  def move(move: Move) = Try[Piece] {
    ???
  }

}
