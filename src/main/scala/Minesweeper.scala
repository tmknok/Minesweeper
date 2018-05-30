import java.util.Scanner

object Minesweeper {

  def main(args: Array[String]) {
    println("Hello")

    val peli = new Taulu(10,10)
    //peli.tulostaTaulu()
    //println()
    peli.lisaaPommit(10)
    peli.tulostaTaulu()
    println()

    val pelaajaTaulu = new Taulu(10,10)
    pelaajaTaulu.tulostaTaulu()

    while (pelaajaTaulu.annaGameOver() != true) {
      val scanner = new Scanner(System.in)
      println("Anna x")
      val x = scanner.nextInt()-1
      println("Anna y")
      val y = scanner.nextInt()-1
      pelaajaTaulu.naytaTyhjat(x,y)
      pelaajaTaulu.avaa(x, y, peli)
      pelaajaTaulu.tulostaTaulu()
    }
  }
}
