import java.util.Scanner

object Minesweeper {

  def main(args: Array[String]) {
    println("Hello")

    val peli = new Taulu(10,10)
    peli.tulostaTaulu()
    println()
    peli.lisaaPommit(5)
    peli.tulostaTaulu()
    println()

    val pelaajaTaulu = new Taulu(10,10)
    pelaajaTaulu.tulostaTaulu()

    val scanner = new Scanner(System.in)
    println("Anna x")
    val x = scanner.nextInt()
    println("Anna y")
    val y = scanner.nextInt()

    pelaajaTaulu.paivitaTaulu(x, y, peli)
    pelaajaTaulu.tulostaTaulu()

  }
}
