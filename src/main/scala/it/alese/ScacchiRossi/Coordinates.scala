package it.alese.ScacchiRossi

case class Coordinates(x: Int, y: Int) {

  private final val charToIntMap: Map[Char, Int] = ('A' to 'H') zip (0 to 8) toMap

}
