package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Row, Column}

case class Position(column: Column, row: Row)

object Position {
  def apply(position: String): Position = {
    require(position.length == 2)
    new Position(Column(position(0)), Row(position(1).toInt - 48))
  }
}
