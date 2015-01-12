package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Row, Column}

case class Position(column: Column, row: Row) {
  def x: Int = column.toInt - 1
  def y: Int = row.toInt - 1

  override def toString = {
    s"$x$y"
  }

}

object Position {
  def apply(position: String): Position = {
    require(position.length == 2, "Illegal coordinate string")
    new Position(Column(position(0)), Row(position(1).asDigit))
  }
}
