import Array._

class Taulu (a: Int, b: Int) {
 // def luoTaulu(): Unit = {
    val taulu = ofDim[Int] (a, b)

    for (i <- 0 to a-1) {
      for (j <- 0 to b-1) {
        taulu(i)(j) = 0
      }
    }

    def tulostaTaulu(): Unit = {
      for (i <- 0 to 4) {
        for (j <- 0 to 4) {
          print(" " + taulu(i)(j))
        }
      }
    }


  //}



}
