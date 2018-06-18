import scala.util.Random

case class Ruutu (hasMiina: Boolean, liputettu: Boolean, klikattu: Boolean, var miinojaYmparilla: Int) {

  def this() = this(false,false,false,0)

  //palauttaa onko miina
  def miinojenMaara():Int ={
    if (hasMiina) 1 else 0
  }

  def annaMiinojaYmp(): Int = {
    miinojaYmparilla
  }

  def kasvataMiinojaYmp(): Unit = {
    miinojaYmparilla+=1
  }
}


