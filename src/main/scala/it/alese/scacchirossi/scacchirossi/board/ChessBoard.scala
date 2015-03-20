package it.alese.scacchirossi.scacchirossi.board

import it.alese.scacchirossi.scacchirossi.Position

object ChessBoard {
  val validPositions = for {
    col <- Column.validColumns
    row <- Row.validRows
  } yield Position(col, row)
}
