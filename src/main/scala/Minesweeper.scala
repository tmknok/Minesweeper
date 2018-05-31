import java.util.Scanner

object Minesweeper {

  def main(args: Array[String]) {
    println("Hello")

    val window = new Peli()
    window.setVisible(true)

    val rivi = 10
    val sarake = 10

    val peli = new Ruudukko(rivi)
    peli.tulostaRuudukko()
    println()
    peli.luoRuudukko()
    peli.tulostaRuudukko()
    //peli.lisaaPommit(5)
   // peli.tulostaTaulu()
    println()

    //val pelaajaTaulu = new Taulu(10,10)
    //pelaajaTaulu.tulostaTaulu()

    //val scanner = new Scanner(System.in)
    //println("Anna x")
    //val x = scanner.nextInt()
    //println("Anna y")
    //val y = scanner.nextInt()

    //pelaajaTaulu.paivitaTaulu(x, y, peli)
    //pelaajaTaulu.tulostaTaulu()

  }
}
