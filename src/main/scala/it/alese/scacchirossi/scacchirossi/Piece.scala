package it.alese.scacchirossi.scacchirossi


trait Piece {
  val colour: Colour
}

case class Pawn(colour: Colour) extends Piece

case class Rook(colour: Colour) extends Piece {
  def canMove(move: Move): Boolean = {
    ???
  }
}

case class Knight(colour: Colour) extends Piece

case class Bishop(colour: Colour) extends Piece

case class Queen(colour: Colour) extends Piece

case class King(colour: Colour) extends Piece

sealed trait Colour

case object WHITE extends Colour

case object BLACK extends Colour
