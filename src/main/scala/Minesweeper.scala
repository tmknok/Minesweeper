object Minesweeper {

  def main(args: Array[String]) {
    println("Hello")

    val taulu = new Taulu(10,10)
    taulu.tulostaTaulu()
    println()
    taulu.lisaaPommit(5)
    taulu.tulostaTaulu()

  }
}
