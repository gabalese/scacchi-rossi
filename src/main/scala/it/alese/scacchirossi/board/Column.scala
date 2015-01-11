package it.alese.scacchirossi.board

case class Column(index: Char) {
  require('A' to 'H' contains index)
}

object Column {
  val validColumns = 'A' to 'H' map (i => Column(i))
}
