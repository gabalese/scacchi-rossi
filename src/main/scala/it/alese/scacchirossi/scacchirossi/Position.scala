package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}

case class Position(column: Column, row: Row) {

  val x: Int = column.toInt

  val y: Int = row.toInt

  def to(toPosition: Position): List[Position] = {
    Move(this, toPosition).intermediatePositions
  }

  def +(x: Int, y: Int) = {
    val col = if (this.x + x != 0) Column(this.x + x) else this.column
    val row = if (this.y + y != 0) Row(this.y + y) else this.row
    new Position(col, row)
  }

  override def toString = {
    s"${column.toChar}$y"
  }

}

object Position {
  def apply(position: String): Position = {
    require(position.length == 2, "Illegal coordinate string")
    new Position(Column(position(0)), Row(position(1).asDigit))
  }
}
