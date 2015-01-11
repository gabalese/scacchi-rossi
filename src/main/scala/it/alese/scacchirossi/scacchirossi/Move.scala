package it.alese.scacchirossi.scacchirossi

case class Move(from: Position, to: Position) {
  def distance: (Int, Int) = {
    (to.x - from.x, to.y - from.y)
  }
}
