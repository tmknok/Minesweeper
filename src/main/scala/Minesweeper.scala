object Minesweeper {

  def main(args: Array[String]) {
    println("Hello")

    val taulu = new Taulu(5,5)
    taulu.tulostaTaulu()
    println()
    taulu.lisaaPommit(3)
    taulu.tulostaTaulu()

  }
}
