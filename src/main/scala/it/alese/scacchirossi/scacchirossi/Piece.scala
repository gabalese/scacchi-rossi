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
    /*
     * This is tricky: the pawn can only move one forward, EXCEPT on the first move  when
     * it might move two forward, and when capturing another piece, where it moves NW or NE
     * This depends on the state of the chessboard.
     */
    move.distance match {
      case (x, y) if math.abs(x) == math.abs(y) && math.abs(x) == 1 => true
      case (0, y) if 1 <= y && y <= 2 => true
      case _ => false
    }
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
  override def isLegalMove(move: Move): Boolean = {
    move.distance match {
      case (x, y) if math.abs(math.abs(x) - math.abs(y)) == 1 => true
      case _ => false
    }
  }
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
  override def isLegalMove(move: Move): Boolean = {
    if (Rook(colour).isLegalMove(move) || Bishop(colour).isLegalMove(move)) true
    else false
  }
}

case class King(colour: Colour) extends Piece {
  override def isLegalMove(move: Move): Boolean = {
    move.distance match {
      case (x, y) if math.abs(x) <= 1 && math.abs(y) <= 1 => true
      case _ => false
    }
  }
}

