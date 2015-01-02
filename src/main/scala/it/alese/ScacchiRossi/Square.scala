package it.alese.ScacchiRossi

import it.alese.ScacchiRossi.Pieces.Piece

class Square {
  private var piece: Option[Piece] = None

  def add(pieceToAdd: Piece): Piece = {
    piece = Some(pieceToAdd)
    piece.get
  }

  def isEmpty: Boolean = {
    piece.isEmpty
  }

  def getPiece: Option[Piece] = {
    piece
  }

}
