package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}

case class ChessBoard(board: Map[Position, Piece])

object ChessBoard {
  val validPositions = for {
    col <- Column.validColumns
    row <- Row.validRows
  } yield Position(col, row)
}
