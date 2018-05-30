import scala.util.Random

class Ruudukko (val riveja: Int, val sarakkeita: Int, val miinoja: Int){
  def this() = this (9,9,9)
  //Täytetään ruudukko ruuduilla
  var ruudut:Array[Array[Ruutu]] = Array.fill(riveja,sarakkeita)(new Ruutu())
  //Luodaan ruudukko

  def luoRuudukko():Array[Array[Ruutu]] = {
    println("luodaan")
    lisaaPommit(miinoja)
    lisaaVihjeet()
  }

  def lisaaPommit(pLkm: Int): Unit ={
    var apu = pLkm
    while (apu > 0){
      val x = Random.nextInt(riveja)
      val y = Random.nextInt(sarakkeita)
      if (ruudut(x)(y) == 0){
        ruudut(x)(y) = 9
        apu -= 1
        //lisaaVihjeet(x,y)
      }
    }
  }

  def lisaaVihjeet(x: Int, y: Int): Unit = {
    if(onkoTaululla(x-1,y-1)) {ruudut(x - 1)(y - 1) = boom(x-1,y-1)}
    if(onkoTaululla(x-1,y)) {ruudut(x - 1)(y) =  boom(x-1,y)}
    if(onkoTaululla(x-1,y+1)) {ruudut(x - 1)(y + 1) = boom(x-1,y+1)}
    if(onkoTaululla(x,y-1)) {ruudut(x)(y - 1) = boom(x,y-1)}
    if(onkoTaululla(x,y+1)) {ruudut(x)(y + 1) = boom(x,y+1)}
    if(onkoTaululla(x+1,y-1)) {ruudut(x + 1)(y - 1) = boom(x+1,y-1)}
    if(onkoTaululla(x+1,y)) {ruudut(x + 1)(y) = boom(x+1,y)}
    if(onkoTaululla(x+1,y+1)) {ruudut(x + 1)(y + 1) = boom(x+1,y+1)}
  }

  def boom(x: Int, y: Int): Int ={
    if (ruudut(x)(y) == ) {
      ruudut(x)(y)
    } else {
      ruudut(x)(y) + 1
    }
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



}
