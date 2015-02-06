package it.alese.scacchirossi.scacchirossi

sealed trait Colour
case object WHITE extends Colour
case object BLACK extends Colour

trait Piece {
  val colour: Colour
  def isLegalMove(move: Move): Boolean
}

case class Pawn(colour: Colour) extends Piece {
  override def isLegalMove(move: Move): Boolean = {
    ???
  }
}

case class Rook(colour: Colour) extends Piece {
  override def isLegalMove(move: Move): Boolean = {
    move.distance match {
      case (0, _) => true
      case (_, 0) => true
      case _ => false
    }
  }
}

case class Knight(colour: Colour) extends Piece {
  override def isLegalMove(move: Move): Boolean = ???
}

case class Bishop(colour: Colour) extends Piece {
  override def isLegalMove(move: Move): Boolean = {
    move.distance match {
      case (x, y) => math.abs(x) == math.abs(y)
      case _ => false
    }
  }
}

case class Queen(colour: Colour) extends Piece {
  override def isLegalMove(move: Move): Boolean = ???
}

case class King(colour: Colour) extends Piece {
  override def isLegalMove(move: Move): Boolean = {
    move.distance match {
      case (x, y) if math.abs(x) <= 1 && math.abs(y) <= 1 => true
      case _ => false
    }
  }
}

