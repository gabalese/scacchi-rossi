package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Row, Column}

case class Position(column: Column, row: Row) {

  def x: Int = column.toInt
  def y: Int = row.toInt

  def to(toPosition: Position): List[Position] = {

    val horizontalOffset = toPosition.x - x
    val verticalOffset = toPosition.y - y

    if (horizontalOffset == 0 || verticalOffset == 0) {
      // straight line movement
      val positions = this.x to toPosition.x flatMap { col => this.y to toPosition.y map { row => Position(Column(col), Row(row))}}
      positions.toList
    } else if (horizontalOffset == verticalOffset) {
      // diagonal movement
      val positions = (0 to verticalOffset by verticalOffset.signum) map { addendum => this + (addendum, addendum) }
      positions.toList
    } else {
      // L-shaped movement
      // We assume that one moves the Knight vertically then horizontally
      // the intermediate positions between a L-shaped movement are irrelevant, i.e. the Knight can jump over other pieces
      val horizontalPositions = ((0 to verticalOffset by verticalOffset.signum) map { addendum => this +(0, addendum)}).toList
      val verticalPositions = ((0 to horizontalOffset by horizontalOffset.signum) map { addendum => horizontalPositions.last + (addendum, 0)}).toList
      horizontalPositions ++ verticalPositions.tail // verticalPosition.head == horizontalPosition.last
      }
    }

  def +(x: Int, y: Int) = {
    val col = if(this.x + x != 0) Column(this.x + x) else this.column
    val row = if(this.y + y != 0) Row(this.y + y) else this.row
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
