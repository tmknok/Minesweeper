import scala.util.Random

class Ruudukko (val riveja: Int, val sarakkeita: Int, val miinoja: Int){
  def this(koko: Int) = this (koko,koko,koko.*(2))
  //Täytetään ruudukko ruuduilla
  var ruudut:Array[Array[Ruutu]] = Array.fill(riveja,sarakkeita)(new Ruutu())
  //Luodaan ruudukko

  def luoRuudukko():Unit = {
    println("luodaan")
    lisaaPommit(miinoja)
    //lisaaVihjeet()
  }

  def lisaaPommit(pLkm: Int): Unit ={

    val x = Random.nextInt(riveja)
    val y = Random.nextInt(sarakkeita)
    if (pLkm > 0) {
      if (ruudut(x)(y).hasMiina) {
        lisaaPommit(pLkm)
      } else {
        ruudut(x)(y) = ruudut(x)(y).copy(hasMiina = true)
        lisaaVihjeet(x,y)
        lisaaPommit(pLkm.-(1))
      }
    }

  }

 /*/ def lisaaVihjeet(x: Int, y: Int): Unit = {
    if(onkoTaululla(x-1,y-1)) {ruudut(x - 1)(y - 1) = boom(x-1,y-1)}
    if(onkoTaululla(x-1,y)) {ruudut(x - 1)(y) =  boom(x-1,y)}
    if(onkoTaululla(x-1,y+1)) {ruudut(x - 1)(y + 1) = boom(x-1,y+1)}
    if(onkoTaululla(x,y-1)) {ruudut(x)(y - 1) = boom(x,y-1)}
    if(onkoTaululla(x,y+1)) {ruudut(x)(y + 1) = boom(x,y+1)}
    if(onkoTaululla(x+1,y-1)) {ruudut(x + 1)(y - 1) = boom(x+1,y-1)}
    if(onkoTaululla(x+1,y)) {ruudut(x + 1)(y) = boom(x+1,y)}
    if(onkoTaululla(x+1,y+1)) {ruudut(x + 1)(y + 1) = boom(x+1,y+1)}
  }

  def boom(x: Int, y: Int): Unit  ={
    if (ruudut(x)(y).hasMiina) {
      ruudut(x)(y).miinojaYmparilla+=1
    } else {

    }
  }*/

  def lisaaVihjeet(x: Int, y: Int): Unit = {
    if(onkoTaululla(x-1,y-1)) {ruudut(x - 1)(y - 1).kasvataMiinojaYmp()}
    if(onkoTaululla(x-1,y)) {ruudut(x - 1)(y).kasvataMiinojaYmp()}
    if(onkoTaululla(x-1,y+1)) {ruudut(x - 1)(y + 1).kasvataMiinojaYmp()}
    if(onkoTaululla(x,y-1)) {ruudut(x)(y - 1).kasvataMiinojaYmp()}
    if(onkoTaululla(x,y+1)) {ruudut(x)(y + 1).kasvataMiinojaYmp()}
    if(onkoTaululla(x+1,y-1)) {ruudut(x + 1)(y - 1).kasvataMiinojaYmp()}
    if(onkoTaululla(x+1,y)) {ruudut(x + 1)(y).kasvataMiinojaYmp()}
    if(onkoTaululla(x+1,y+1)) {ruudut(x + 1)(y + 1).kasvataMiinojaYmp()}
  }

  def onkoTaululla(x: Int, y: Int): Boolean ={
    if (x<0 || y<0 || x >= riveja || y >= sarakkeita) {
      return false
    }
    true
  }

  def tulostaRuudukko(): Unit = {
    for (i<-0 until riveja) {
      for (j <- 0 until sarakkeita) {
        if (ruudut(i)(j).hasMiina) {
          print("* ")
        } else {
          print(ruudut(i)(j).miinojaYmparilla + " ")
        }
      }
      println()
    }
  }


}
