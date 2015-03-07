package it.alese.scacchirossi.scacchirossi

case class Game(chessboard: Map[Position, Piece], moves: List[Move]) {
  def move(move: Move): Game = {
    val pieceToMove = chessboard.get(move.start)
    pieceToMove.fold(this){piece =>
      val boardAfterMove = (chessboard - move.start) + (move.end -> piece)
      Game(boardAfterMove, moves :+ move)
    }
  }
}

object Game {
  private val startBoard: Map[Position, Piece] = Map(
  // Rooks
    Position("A1") -> Rook(WHITE),
    Position("H1") -> Rook(WHITE),
    Position("A8") -> Rook(BLACK),
    Position("H8") -> Rook(BLACK),
  // Knights
    Position("B1") -> Knight(WHITE),
    Position("G1") -> Knight(WHITE),
    Position("B8") -> Knight(BLACK),
    Position("G8") -> Knight(BLACK),
  // Bishops
    Position("C1") -> Bishop(WHITE),
    Position("F1") -> Bishop(WHITE),
    Position("C8") -> Bishop(BLACK),
    Position("F8") -> Bishop(BLACK),
  // Queens
    Position("D1") -> Queen(WHITE),
    Position("D8") -> Queen(BLACK),
  // Kings
    Position("E1") -> King(WHITE),
    Position("E8") -> King(BLACK),
  // White Pawns
    Position("A2") -> Pawn(WHITE),
    Position("B2") -> Pawn(WHITE),
    Position("C2") -> Pawn(WHITE),
    Position("D2") -> Pawn(WHITE),
    Position("E2") -> Pawn(WHITE),
    Position("F2") -> Pawn(WHITE),
    Position("G2") -> Pawn(WHITE),
    Position("H2") -> Pawn(WHITE),
  // Black Pawns
    Position("A7") -> Pawn(BLACK),
    Position("B7") -> Pawn(BLACK),
    Position("C7") -> Pawn(BLACK),
    Position("D7") -> Pawn(BLACK),
    Position("E7") -> Pawn(BLACK),
    Position("F7") -> Pawn(BLACK),
    Position("G7") -> Pawn(BLACK),
    Position("H7") -> Pawn(BLACK)
  )
  def start(): Game = new Game(startBoard, List[Move]())
}
