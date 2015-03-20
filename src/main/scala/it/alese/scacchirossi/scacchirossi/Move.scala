package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{ChessBoard, Column, Row}

case class Move(start: Position, end: Position) {
  require(ChessBoard.validPositions contains start)
  require(ChessBoard.validPositions contains end)
  require(start != end)

  private val offset = Offset(end.x - start.x, end.y - start.y)

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
    lazy val positions = start.x to end.x flatMap { col => start.y to end.y map { row => Position(Column(col), Row(row))}}
    positions.toList
  }

  private def fetchDiagonalPositions: List[Position] = {
    lazy val positions = (0 to offset.vertical by offset.vertical.signum) map { addendum => start +(addendum, addendum)}
    positions.toList
  }

  private def fetchLshapedPositions: List[Position] = {
    // We assume that one moves the Knight vertically then horizontally
    // the intermediate positions between a L-shaped movement are irrelevant, i.e. the Knight can jump over other pieces
    lazy val horizontalPositions = ((0 to offset.vertical by offset.vertical.signum) map { addendum => start +(0, addendum)}).toList
    lazy val verticalPositions = ((0 to offset.horizontal by offset.horizontal.signum) map { addendum => horizontalPositions.last +(addendum, 0)}).toList
    horizontalPositions ++ verticalPositions.tail // verticalPosition.head == horizontalPosition.last
  }

}

case class Offset(horizontal: Int, vertical: Int)
