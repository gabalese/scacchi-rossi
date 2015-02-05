package it.alese.scacchirossi.scacchirossi

object LetterToIntMap {
  private val letterMap: Map[Char, Int] = Map(
    'A' -> 1,
    'B' -> 2,
    'C' -> 3,
    'D' -> 4,
    'E' -> 5,
    'F' -> 6,
    'G' -> 7,
    'H' -> 8
  )

  private val intMap = letterMap.map(_.swap)

  def apply(letter: Char): Int = {
    letterMap(letter)
  }

  def apply(int: Int): Char = {
    intMap(int)
  }
}
