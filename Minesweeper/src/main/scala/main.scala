import Array._

class main {

  //tänne tulee pelijuttuja
  //luoTaulu()
  //tulostaTaulu()
  var taulu = ofDim[Int](5, 5)

  for (i <- 0 to 4) {
    for (j <- 0 to 4) {
      taulu(i)(j) = 0
    }
  }
    for (i <- 0 to 4) {
      for (j <- 0 to 4) {
        print(" " + taulu(i)(j))
      }
    }

}
