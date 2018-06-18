import scala.util.Random
import scala.annotation.tailrec

class Ruudukko (val riveja: Int, val sarakkeita: Int, val miinoja: Int ){

  def this(koko: Int) = this (koko,koko,10)
  //Täytetään ruudukko ruuduilla
  var ruudut:Array[Array[Ruutu]] = Array.fill(riveja,sarakkeita)(new Ruutu())
  this.lisaaPommit(10)

  def annaRivit(): Int = {
    riveja
  }

  def annaSarakkeet(): Int = {
    sarakkeita
  }

  def annaMiinat(): Int = {
    miinoja
  }
  //Luodaan ruudukko
  def luoRuudukko():Unit = {
    lisaaPommit(miinoja)
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


  def annaRuutu(x: Int, y: Int): Ruutu = {
      ruudut(x)(y)
  }


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


  def avaaRuutu(x: Int, y: Int): Unit = {
    if (onkoTaululla(x,y)) {
      val ruutu = (ruudut(x)(y).klikattu, ruudut(x)(y).hasMiina, ruudut(x)(y).miinojaYmparilla)
      ruutu match {
        case (false,false,0) =>
          ruudut(x)(y) = ruudut(x)(y).copy(klikattu = true)
          naytaNaapurit(x, y)
        case _ => ruudut(x)(y) = ruudut(x)(y).copy(klikattu = true)

      }
    }
  }

  def naytaNaapurit(x: Int, y: Int): Unit = {
    @tailrec
    def loop(nytX: Int, nytY: Int): Unit = {
      avaaRuutu(nytX, nytY)
      if(nytX == x.+(1) && nytY == y.+(1)) {
      } else {
        if(nytY < y.+(1)) {
          loop(nytX, nytY.+(1))
        } else {
          loop(nytX.+(1), nytY.-(1))
        }
      }
    }
    loop(x.-(1),y.-(1))
  }

  def osuttuMiinaan(): Boolean ={
    for (i<-0 until riveja; j<-0 until sarakkeita) {
      if (ruudut(i)(j).klikattu && ruudut(i)(j).hasMiina) {
        return true
      }
    }
    false
  }



  def vainMiinoja(): Boolean = {
    var laskin = 0
    for (i<-0 until riveja; j<-0 until sarakkeita) {
      if (!ruudut(i)(j).klikattu) {
        laskin += 1
      }
    }
    if (laskin > miinoja) {
      return false
    }
    true
  }
}
