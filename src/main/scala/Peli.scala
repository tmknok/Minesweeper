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

  val rivit = 9
  val sarakkeet = 9
  val miinat = 9

  val body = new JPanel()
  val peliRuutu = new JPanel()
  val toolBar = new JToolBar()
  val btnLevel1 = new JLabel()

  val ruutu = new ImageIcon("kuvat/ruutu4.png")
  val lippu = new ImageIcon("kuvat/lippu.png")
  val pommi = new ImageIcon("kuvat/miina.png")

  val taustaVari = new Color(135, 199, 217)

  def teeRuudukko(peli: Ruudukko) {
    val ruudukko = new GridLayout()
    ruudukko.setRows(peli.annaRivit())
    ruudukko.setColumns(peli.annaSarakkeet())
    peliRuutu.setLayout(ruudukko)
  }

  def alustaRuudukko(peli: Ruudukko) {
    val painikkeet = List.tabulate(peli.annaRivit(), peli.annaSarakkeet())((_, _) => new JLabel(ruutu))
    peliRuutu.removeAll()
    painikkeet.flatten.map(button => peliRuutu.add(button))
    validate()
    repaint()

    def paivitaPeli(peli: Ruudukko) {
      painikkeet.flatten.foreach(button => {
        val panelX = (button.getX() / button.getSize().getWidth()).toInt
        val panelY = (button.getY() / button.getSize().getHeight()).toInt

        val ruutu = peli.annaRuutu(panelX, panelY)

        if (ruutu.klikattu && !ruutu.hasMiina && ruutu.miinojaYmparilla == 0) {
          button.setIcon(null)
          button.revalidate()
          button.setOpaque(true)
          button.setBackground(taustaVari)
          button.setBorder(BorderFactory.createLineBorder(new Color(49, 133, 156)))
          button.setForeground(new Color(119, 147, 60))
        } else {
          if (ruutu.klikattu && !ruutu.hasMiina && ruutu.miinojaYmparilla > 0) {
            button.setIcon(null)
            button.revalidate()
            button.setOpaque(true)
            button.setBackground(taustaVari)
            button.setBorder(BorderFactory.createLineBorder(new Color(49, 133, 156)))
            button.setForeground(new Color(128, 100, 162))
            button.setText(ruutu.miinojaYmparilla.toString)
          } else {
            if (ruutu.klikattu && ruutu.hasMiina) {
              button.setIcon(pommi)
            }
          }
        }

        button.addMouseListener(new MouseAdapter() {
          override def mouseReleased(e: MouseEvent) {
            showCell(button, panelX, panelY)
          }
        })
      })
    }

    paivitaPeli(peli)
    validate()
    repaint()
    paivitaPeli(peli)

    if (peli.osuttuMiinaan()) {
      JOptionPane.showInternalMessageDialog(body, "LUUSERI", "Miina räjähti!",
        JOptionPane.ERROR_MESSAGE)
      alustaRuudukko(peli)
    } else if (peli.vainMiinoja()) {
      JOptionPane.showInternalMessageDialog(body, "WINNER TAKES IT ALL!", "Voitit pelin!",
        JOptionPane.INFORMATION_MESSAGE)
      alustaRuudukko(peli)
    }

    def showCell(button: JLabel, panelX: Int, panelY: Int): Unit = {
      if (button.isEnabled()) {
        button.setEnabled(false)
        peli.avaaRuutu(panelX, panelY)
        alustaRuudukko(peli)
      }
    }
  }

  def uusiPeli(peli: Ruudukko): Unit = {
    peliRuutu.addMouseListener(new MouseAdapter() {
      override def mouseReleased(e: MouseEvent): Unit = {
        alustaRuudukko(peli)
      }
    })
  }

  def defineBody() {
    body.setLayout(new BorderLayout())
    body.add(peliRuutu, BorderLayout.CENTER)
    //body.add(toolBar, BorderLayout.NORTH)
  }


  def alustaTaso(peli: Ruudukko): Unit = {
    setSize(peli.annaRivit() * (ruutu.getIconWidth - 1), peli.annaSarakkeet() * ruutu.getIconHeight)
    getContentPane.removeAll()
    setContentPane(body)
    validate()
    repaint()
    peli.lisaaPommit(miinat)
    uusiPeli(peli)
    teeRuudukko(peli)
    alustaRuudukko(peli)

  }

  val hula = new Ruudukko(rivit, sarakkeet, miinat)
  alustaTaso(hula)

  defineBody()

  setTitle("Miinaharava")
  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

}
