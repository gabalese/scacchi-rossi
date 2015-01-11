package it.alese.scacchirossi.scacchirossi.board

case class Row(index: Int) {
  require(1 to 8 contains index)
  def toInt = {
    index
  }
}

object Row {
  val validRows = 1 to 8 map (Row(_))
}
