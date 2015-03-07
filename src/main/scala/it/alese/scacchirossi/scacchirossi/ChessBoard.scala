package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}

object ChessBoard {
  val validPositions = for {
    col <- Column.validColumns
    row <- Row.validRows
  } yield Position(col, row)
}
