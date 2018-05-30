import java.awt.BorderLayout
import java.awt.GridLayout
import java.awt.event.InputEvent
import java.util.Random
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JProgressBar
import javax.swing.JToggleButton
import javax.swing.JToolBar
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.WindowConstants
import javax.swing.JLabel
import javax.swing.ImageIcon
import java.awt.Color

import javax.swing.border.Border
import javax.swing.BorderFactory

//import scala.swing._

class Peli extends JFrame {

  val rowsLvl1 = 9
  val columnsLvl1 = 9
  val bombsLvl1 = 9

  //val intro = new IntroPanel()
  val body = new JPanel()
  val peliRuutu = new JPanel()
  val toolBar = new JToolBar()
  //val btnLevel1 = new JLabel()

  //val newGame = new JLabel(new ImageIcon("img/nwGame.png"))
  val ruutu = new ImageIcon("kuvat/square.png")
  val lippu = new ImageIcon("kuvat/lippu.png")
  val pommi = new ImageIcon("kuvat/miina.png")

  //val emptyIcon = new ImageIcon("img/empty.png")

  val taustaVari = new Color(135, 199, 217)

  def teeRuudukko(peli: Taulu) {
    val ruudukko = new GridLayout()
    ruudukko.setRows(peli.annaRivit())
    ruudukko.setColumns(peli.annaSarakkeet())
    peliRuutu.setLayout(ruudukko)
  }

  def alustaPaneeli(peli: Taulu) {
    val painikkeet = List.tabulate(peli.annaRivit(), peli.annaSarakkeet())((_, _) => new JLabel(ruutu))
    peliRuutu.removeAll()
    painikkeet.flatten.map(button => peliRuutu.add(button))
    validate()
    repaint()


    def paivitaPeli(peli: Taulu) {
      painikkeet.flatten.map(button => {







}
