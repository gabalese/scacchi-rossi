package it.alese.ScacchiRossi

class Position(x: Char, y: Int) {

  require((1 to 8).contains(y))
  require(('a' to 'h').contains(x.toLower))
  
  def getX: Int = {
    x.toLower.toInt - 97
  }

  def getY: Int = {
    y - 1
  }

  override def hashCode: Int = {
    31 * y + x.toLower.toInt
  }

  override def equals(other: Any): Boolean = {
    other match {
      case that: Position => this.getX == that.getX && this.getY == that.getY
      case _ => false
    }
  }

}
