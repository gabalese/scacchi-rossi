package it.alese.ScacchiRossi

import it.alese.ScacchiRossi.Pieces.Piece

class ChessBoard {
    val board = new scala.collection.mutable.HashMap[Position, Square]()

    (1 to 8).map{
        num => ('A' to 'H').map{
            let => board.put(new Position(let, num), new Square())
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
