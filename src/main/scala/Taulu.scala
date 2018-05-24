import Array._
import scala.util.Random

class Taulu (a: Int, b: Int) {
  // def luoTaulu(): Unit = {
  val taulu = ofDim[Int] (a, b)
  val r = scala.util.Random

  for (i <- 0 until a) {
    for (j <- 0 until b) {
      taulu(i)(j) = 0
    }
  }

  def tulostaTaulu(): Unit = {
    for (i <- 0 until a) {
      for (j <- 0 until b) {
        print(" " + taulu(i)(j))
      }
      println()
    }
  }

  def lisaaPommit(x: Int): Unit ={
    for (i <- 0 until x){
      taulu(r.nextInt(a-1))(r.nextInt(b-1)) = 9
    }
  }


  //}



}
