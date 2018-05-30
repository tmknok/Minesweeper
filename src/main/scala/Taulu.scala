import Array._
import scala.util.Random

class Taulu (a: Int, b: Int) {
  // def luoTaulu(): Unit = {
  val taulu = ofDim[Int] (a, b)
  val r = scala.util.Random
  var gameOver = false

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

  def lisaaPommit(pLkm: Int): Unit ={
    var apu = pLkm
    while (apu > 0){
      val x = r.nextInt(a - 1)
      val y = r.nextInt(b-1)
      if (taulu(x)(y) == 0){
        taulu(x)(y) = 9
        apu -= 1
        lisaaVihjeet(x,y)
      }
    }
  }

  def lisaaVihjeet(x: Int, y: Int): Unit = {
      if(onkoTaululla(x-1,y-1)) {taulu(x - 1)(y - 1) = boom(x-1,y-1)}
      if(onkoTaululla(x-1,y)) {taulu(x - 1)(y) =  boom(x-1,y)}
      if(onkoTaululla(x-1,y+1)) {taulu(x - 1)(y + 1) = boom(x-1,y+1)}
      if(onkoTaululla(x,y-1)) {taulu(x)(y - 1) = boom(x,y-1)}
      if(onkoTaululla(x,y+1)) {taulu(x)(y + 1) = boom(x,y+1)}
      if(onkoTaululla(x+1,y-1)) {taulu(x + 1)(y - 1) = boom(x+1,y-1)}
      if(onkoTaululla(x+1,y)) {taulu(x + 1)(y) = boom(x+1,y)}
      if(onkoTaululla(x+1,y+1)) {taulu(x + 1)(y + 1) = boom(x+1,y+1)}
  }

  def boom(x: Int, y: Int): Int ={
    if (taulu(x)(y) == 9) {
      taulu(x)(y)
    } else {
      taulu(x)(y) + 1
    }
  }

  def gameOver (x:Int, y:Int) : Unit ={
    if (taulu (x)(y) == 9){
      gameOver = true
    }
  }

  def annaGameOver ():Boolean={
    gameOver
  }

  def onkoTaululla(x: Int, y: Int): Boolean ={
    if (x<0 || y<0) {
      return false
    }
    if (x >= a || y >= b) {
      return false
    }
    true
  }

  def annaArvo(x: Int,y: Int): Int ={
    taulu(x)(y)
  }

  def paivitaTaulu(x: Int, y: Int, peli: Taulu): Unit ={
    taulu(x)(y)=peli.annaArvo(x,y)
  }




  //}



}
