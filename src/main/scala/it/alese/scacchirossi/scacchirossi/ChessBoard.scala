package it.alese.scacchirossi.scacchirossi

import it.alese.scacchirossi.scacchirossi.board.{Column, Row}

case class ChessBoard(board: Map[Position, Square], pastMoves: List[Move]) {

  def isFirstMove = pastMoves.isEmpty
  def completedMoves = pastMoves

  def get(position: Position): Option[Square] = board.get(position)

  def put(position: Position, piece: Piece): Either[java.lang.Throwable, ChessBoard] = {
    val square = board.get(position)
    square match {
      case Some(container) =>
        if (container.hasColour(piece.colour))
          Left(new Exception(s"Illegal move: already a ${piece.colour} on square"))
        else
          container.put(piece) match {
            case Left(ex) => Left(ex)
            case Right(newSquare: Square) => Right(ChessBoard(board.updated(position, newSquare), Nil))
          }
      case None =>
        val square = Square(None, None)
        square.put(piece) match {
          case Right(newSquare) => Right(ChessBoard(board.updated(position, newSquare), Nil))
          case Left(ex) => Left(ex)
        }
    }
  }

  def move(move: Move): ChessBoard = {
    val square = get(move.start)
    square match {
      case Some(square) if square.isAvailable => {
        put(move.end, square.get) match {
          case Right(board) => board
          case Left(ex) => this
        }
      }
      case _ => this
    }
  }

  def init(): ChessBoard = {
    def addPiecesToBoard(board: ChessBoard, pieces: List[(Position, Piece)]): ChessBoard = {
      pieces match {
        case (pos, piec) :: tail => board.put(pos, piec) match {
          case Right(newBoard) => addPiecesToBoard(newBoard, tail)
          case Left(ex) => throw new Exception(ex.getMessage)
        }
        case Nil => board
      }
    }

    val pieces: List[(Position, Piece)] =
      List(
        (Position("A1"), Rook(WHITE)),
        (Position("H1"), Rook(WHITE)),
        (Position("A8"), Rook(BLACK)),
        (Position("H8"), Rook(BLACK)),
        (Position("B1"), Knight(WHITE)),
        (Position("G1"), Knight(WHITE)),
        (Position("B8"), Knight(BLACK)),
        (Position("G8"), Knight(BLACK)),
        (Position("C1"), Bishop(WHITE)),
        (Position("F1"), Bishop(WHITE)),
        (Position("C8"), Bishop(BLACK)),
        (Position("F8"), Bishop(BLACK)),
        (Position("D1"), Queen(WHITE)),
        (Position("D8"), Queen(BLACK)),
        (Position("E1"), King(WHITE)),
        (Position("E8"), King(BLACK))
      )

    val boardWithWhitePawns = addPiecesToBoard(this, Column.validColumns.map { col => (Position(col, Row(2)), Pawn(WHITE))}.toList)
    val boardWithBlackPawns = addPiecesToBoard(boardWithWhitePawns, Column.validColumns.map { col => (Position(col, Row(7)), Pawn(BLACK))}.toList)
    val fullBoard = addPiecesToBoard(boardWithBlackPawns, pieces)
    fullBoard
  }
}

object ChessBoard {
  val validPositions = for {
    col <- Column.validColumns
    row <- Row.validRows
  } yield Position(col, row)
}

case class Square(white: Option[Piece], black: Option[Piece]) {
  def isEmpty: Boolean = !hasWhite && !hasBlack
  def hasBlack: Boolean = black.isDefined
  def hasWhite: Boolean = white.isDefined
  def isAvailable: Boolean = !hasWhite || !hasBlack

  def hasColour(colour: Colour): Boolean = {
    (colour == WHITE && hasWhite) || (colour == BLACK && hasBlack)
  }

  def get: Piece = {
    if(hasWhite) white.get else black.get
  }

  def put(piece: Piece): Either[java.lang.Throwable, Square] = {
    require(isAvailable)
    if (piece.isWhite) putWhite(piece) else putBlack(piece)
  }

  private def putWhite(piece: Piece): Either[java.lang.Throwable, Square] = {
    if (hasWhite) Left(new Exception("Illegal move"))
    else Right(Square(Some(piece), black))
  }

  private def putBlack(piece: Piece): Either[java.lang.Throwable, Square] = {
    if (hasBlack) Left(new Exception("Illegal move"))
    else Right(Square(white, Some(piece)))
  }

  def remove(piece: Piece): Unit = {
    require(isAvailable)
    if(piece.isWhite) removeWhite(piece) else removeBlack(piece)
  }

  private def removeWhite(piece: Piece) = Square(None, black)
  private def removeBlack(piece: Piece) = Square(white, None)
}
