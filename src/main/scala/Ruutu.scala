import scala.util.Random

class Ruutu (hasMiina:Boolean, liputettu: Boolean, klikattu: Boolean, miinojaYmparilla: Int) {
  def this () = this(false,false,false,0)

  //palauttaa onko miina
  def miinojenMaara():Int ={
    if (this.hasMiina) 1 else 0
  }
}
