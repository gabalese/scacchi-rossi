package it.alese.scacchirossi.scacchirossi


trait Piece {
  val colour: Colour
}

class Pawn(val colour: Colour) extends Piece
class Rook(val colour: Colour) extends Piece
class Knight(val colour: Colour) extends Piece
class Bishop(val colour: Colour) extends Piece
class Queen(val colour: Colour) extends Piece
class King(val colour: Colour) extends Piece

trait Colour
case object WHITE extends Colour
case object BLACK extends Colour
