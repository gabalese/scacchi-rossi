package it.alese.scacchirossi

import it.alese.scacchirossi.Pieces.Piece

class ChessBoard {
    private[scacchirossi] val board = new scala.collection.mutable.HashMap[Position, Square]()

    (1 to 8).map{
        row => ('A' to 'H').map{
            column => board.put(new Position(column, row), new Square())
        }
    }

    def getSquareAt(coordinates: Position): Square = {
        board(coordinates)
    }

    def setPieceAt(coordinates: Position, piece: Piece): Square = {
        val square = getSquareAt(coordinates)
        square.add(piece)
        square
    }
}
