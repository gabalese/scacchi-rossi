package it.alese.scacchirossi.scacchirossi

case class Move(from: Position, to: Position) {
  require(ChessBoard.validPositions contains from)
  require(ChessBoard.validPositions contains to)
  def distance: (Int, Int) = {
    (to.x - from.x, to.y - from.y)
  }
}
