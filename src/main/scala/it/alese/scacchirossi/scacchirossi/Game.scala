package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{LockedSquare, FreeSquare, OccupiedSquare, Square}

case class Turn(white: Option[Move], black: Option[Move]) {
  /*
  We have a complete turn when black and white have added their moves
   */
  def addMove(move: Move): Turn = {
    ???
  }
}

case class GameState(game: Game, turn: Turn) {
  /*
  The game state changes the game when the turn is completed
  should it be the main "thing" we manipulate?
   */
  def move(move: Move): GameState = {
    if (LegalMoveChecker(this, move).isLegal) {
      val nexTurn = turn.addMove(move)
      GameState(game, nexTurn)
    } else {
      this
    }
  }
}

case class LegalMoveChecker(state: GameState, move: Move) {
  def isLegal: Boolean = {
    true
  }
}


case class Game(chessboard: Map[Position, Square], moves: List[Move]) {
  def move(move: Move): Game = {
    /*
    Two possible outcomes here:
    1. Players move to different squares => handle the game logic according to the usual rules
    2. Players move to same square => mark the square as locked
       (a position with a locked square means that a move cannot end there)
       (thus having an illegal move according to GameState
    */
    chessboard.getOrElse(move.end, FreeSquare) match {
      case FreeSquare => // do stuff
      case square: OccupiedSquare => // do stuff
      case LockedSquare => // do other stuff
    }
    val pieceToMove = chessboard.get(move.start)
    pieceToMove.fold(this){piece =>
      val boardAfterMove = (chessboard - move.start) + (move.end -> piece)
      Game(boardAfterMove, moves :+ move)
    }
  }
}

object Game {
  private val startChessBoard: Map[Position, Square] = Map(
  // Rooks
    Position("A1") -> OccupiedSquare(Rook(WHITE)),
    Position("H1") -> OccupiedSquare(Rook(WHITE)),
    Position("A8") -> OccupiedSquare(Rook(BLACK)),
    Position("H8") -> OccupiedSquare(Rook(BLACK)),
  // Knights
    Position("B1") -> OccupiedSquare(Knight(WHITE)),
    Position("G1") -> OccupiedSquare(Knight(WHITE)),
    Position("B8") -> OccupiedSquare(Knight(BLACK)),
    Position("G8") -> OccupiedSquare(Knight(BLACK)),
  // Bishops
    Position("C1") -> OccupiedSquare(Bishop(WHITE)),
    Position("F1") -> OccupiedSquare(Bishop(WHITE)),
    Position("C8") -> OccupiedSquare(Bishop(BLACK)),
    Position("F8") -> OccupiedSquare(Bishop(BLACK)),
  // Queens
    Position("D1") -> OccupiedSquare(Queen(WHITE)),
    Position("D8") -> OccupiedSquare(Queen(BLACK)),
  // Kings
    Position("E1") -> OccupiedSquare(King(WHITE)),
    Position("E8") -> OccupiedSquare(King(BLACK)),
  // White Pawns
    Position("A2") -> OccupiedSquare(Pawn(WHITE)),
    Position("B2") -> OccupiedSquare(Pawn(WHITE)),
    Position("C2") -> OccupiedSquare(Pawn(WHITE)),
    Position("D2") -> OccupiedSquare(Pawn(WHITE)),
    Position("E2") -> OccupiedSquare(Pawn(WHITE)),
    Position("F2") -> OccupiedSquare(Pawn(WHITE)),
    Position("G2") -> OccupiedSquare(Pawn(WHITE)),
    Position("H2") -> OccupiedSquare(Pawn(WHITE)),
  // Black Pawns
    Position("A7") -> OccupiedSquare(Pawn(BLACK)),
    Position("B7") -> OccupiedSquare(Pawn(BLACK)),
    Position("C7") -> OccupiedSquare(Pawn(BLACK)),
    Position("D7") -> OccupiedSquare(Pawn(BLACK)),
    Position("E7") -> OccupiedSquare(Pawn(BLACK)),
    Position("F7") -> OccupiedSquare(Pawn(BLACK)),
    Position("G7") -> OccupiedSquare(Pawn(BLACK)),
  Position("H7") -> OccupiedSquare(Pawn(BLACK))
  )
  def start(): Game = new Game(startChessBoard, List.empty[Move])
}
