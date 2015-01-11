package it.alese.scacchirossi.Pieces

trait PawnMovement {

}

abstract class Piece {

}

class Pawn extends Piece with PawnMovement {
  val name = "Pawn"
}

class Rookie extends Piece {
  val name = "Rookie"
}
