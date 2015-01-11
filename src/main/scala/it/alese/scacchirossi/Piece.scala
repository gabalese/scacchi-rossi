package it.alese.scacchirossi


trait Piece {
  val colour: Colour
}

class Pawn(val colour: Colour) extends Piece

trait Colour

case object WHITE extends Colour
case object BLACK extends Colour
