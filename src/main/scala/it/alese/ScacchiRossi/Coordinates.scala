package it.alese.ScacchiRossi

abstract class Coordinates(x: Char, y: Int) {

  require((1 to 8).contains(y))
  require(('a' to 'h').contains(x.toLower))

  def getX: Int
  def getY: Int

}

class ChessCoordinates(x: Char, y: Int) extends Coordinates(x: Char, y: Int) {
  override def getX: Int = {
    return x.toLower.toInt - 97
  }

  override def getY: Int = {
    return y - 1
  }
}
