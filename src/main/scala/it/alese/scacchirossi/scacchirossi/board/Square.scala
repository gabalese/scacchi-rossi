package it.alese.scacchirossi.scacchirossi.board

import it.alese.scacchirossi.scacchirossi.Piece

sealed trait Square

case class OccupiedSquare(piece: Piece) extends Square
case object FreeSquare extends Square
case object LockedSquare extends Square
