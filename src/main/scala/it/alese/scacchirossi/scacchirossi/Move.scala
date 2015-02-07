package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}

case class Move(from: Position, to: Position) {
  require(ChessBoard.validPositions contains from)
  require(ChessBoard.validPositions contains to)
  require(from != to)

  private val offset = Offset(to.x - from.x, to.y - from.y)

  def distance: (Int, Int) = {
    (offset.horizontal, offset.vertical)
  }

  def intermediatePositions: List[Position] = {
    if (isAStraightLine) {
      fetchStraightPositions
    } else if (isADiagonalLine) {
      fetchDiagonalPositions
    } else {
      fetchLshapedPositions
    }
  }

  private def isAStraightLine = offset.horizontal == 0 || offset.vertical == 0

  private def isADiagonalLine = offset.horizontal == offset.vertical

  private def fetchStraightPositions: List[Position] = {
    lazy val positions = from.x to to.x flatMap { col => from.y to to.y map { row => Position(Column(col), Row(row))}}
    positions.toList
  }

  private def fetchDiagonalPositions: List[Position] = {
    lazy val positions = (0 to offset.vertical by offset.vertical.signum) map { addendum => from +(addendum, addendum)}
    positions.toList
  }

  private def fetchLshapedPositions: List[Position] = {
    // We assume that one moves the Knight vertically then horizontally
    // the intermediate positions between a L-shaped movement are irrelevant, i.e. the Knight can jump over other pieces
    lazy val horizontalPositions = ((0 to offset.vertical by offset.vertical.signum) map { addendum => from +(0, addendum)}).toList
    lazy val verticalPositions = ((0 to offset.horizontal by offset.horizontal.signum) map { addendum => horizontalPositions.last +(addendum, 0)}).toList
    horizontalPositions ++ verticalPositions.tail // verticalPosition.head == horizontalPosition.last
  }

}

case class Offset(horizontal: Int, vertical: Int)
