package it.alese.ScacchiRossi

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

    def setSquareAt(coordinates: Position, square: Square): Unit = {
        board.put(coordinates, square)
    }
}
