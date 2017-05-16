package culebrita.interfaz

import scala.swing.Panel
import java.awt.Graphics2D
import java.awt.Color
import culebrita.mundo.Tablero
import java.awt.BasicStroke
import java.awt.Stroke
import scala.swing.Label
import scala.swing.FlowPanel
import java.awt.Font
import scala.swing.GridPanel
import javax.swing.border.Border
import scala.swing.Swing

class PanelPuntos(val tablero: Tablero, val borde: Int) extends GridPanel(1, 2) {
  background = Color.decode("#B2BF1F")
  border = Swing.EmptyBorder(3)

  var labPuntos = new Label() {
    text = "Puntos: 000"
    font = new Font("Press Start 2P", java.awt.Font.BOLD, 18)
    foreground = Color.decode("#6B5E0B")
    border = Swing.EmptyBorder(2)
  }

  var labTop = new Label() {
    text = "Top: 000"
    font = new Font("Press Start 2P", java.awt.Font.BOLD, 18)
    foreground = Color.decode("#6B5E0B")
    border = Swing.EmptyBorder(2)
  }

  contents += labPuntos
  contents += labTop

  def actualizarPuntos(puntos: Int) {
    labPuntos.text = f"Puntos: $puntos%03d"
  }
}