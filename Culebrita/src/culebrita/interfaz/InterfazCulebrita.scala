package culebrita.interfaz

import scala.swing._
import java.awt.Color
import java.awt.event._
import culebrita.mundo.Tablero
import scala.swing.event.KeyPressed
import scala.swing.event.KeyReleased
import scala.swing.event.Key

object InterfazCulebrita extends SimpleSwingApplication {
  private val ancho = 20
  private val alto = 18
  private val escala = 20
  private val borde = 10

  val tablero = new Tablero(ancho, alto)

  def top: Frame = new InterfazCulebrita(tablero, borde, escala) {
    title = "Culebrita"
    resizable = false
  }
}

class InterfazCulebrita(tablero: Tablero, borde: Int, escala: Int) extends MainFrame {

  var canvas = new PanelTablero(tablero, borde, escala) {
    preferredSize = new Dimension((tablero.ancho * escala) + borde * 2, (tablero.alto * escala) + borde * 2)
  }

  var puntaje = new PanelPuntos(tablero, borde)

  contents = new BoxPanel(Orientation.Vertical) {
    contents += puntaje
    contents += canvas

    listenTo(keys)

    reactions += {
      case KeyPressed(_, Key.Up, _, _) => {
        if (tablero.estado != Tablero.Menu)
          tablero.girar(Tablero.Norte)
        else {
          if (tablero.opcionSeleccionada == Tablero.Jugar)
            tablero.opcionSeleccionada = Tablero.Top10
          else tablero.opcionSeleccionada = Tablero.Jugar
        }
      }
      case KeyPressed(_, Key.Right, _, _) => {
        tablero.girar(Tablero.Este)
      }
      case KeyPressed(_, Key.Down, _, _) => {
        if (tablero.estado != Tablero.Menu)
          tablero.girar(Tablero.Sur)
        else {
          if (tablero.opcionSeleccionada == Tablero.Jugar)
            tablero.opcionSeleccionada = Tablero.Top10
          else tablero.opcionSeleccionada = Tablero.Jugar
        }
      }
      case KeyPressed(_, Key.Left, _, _) => {
        tablero.girar(Tablero.Oeste)
      }
      case KeyPressed(_, Key.Key1, _, _) => {
        tablero.velocidad = 1
        tablero.iniciarJuego
      }
      case KeyPressed(_, Key.Key2, _, _) => {
        tablero.velocidad = 2
        tablero.iniciarJuego
      }
      case KeyPressed(_, Key.Key3, _, _) => {
        tablero.velocidad = 3
        tablero.iniciarJuego
      }
      case KeyPressed(_, Key.Enter, _, _) => {
        if (tablero.estado == Tablero.Perdio) {
          tablero.iniciarJuego
        } else if (tablero.estado == Tablero.Pausa) {
          tablero.estado = Tablero.Jugando
        } else if (tablero.estado == Tablero.Menu) {
          if (tablero.opcionSeleccionada == Tablero.Jugar) {
            tablero.iniciarJuego
          } else if (tablero.opcionSeleccionada == Tablero.Top10) {
            tablero.estado = Tablero.Top10
          }
        }
      }
      case KeyPressed(_, Key.Space, _, _) => {
        if (tablero.estado == Tablero.Jugando) {
          tablero.estado = Tablero.Pausa
        } else if (tablero.estado == Tablero.Pausa) {
          tablero.estado = Tablero.Jugando
        }
      }
      case KeyPressed(_, Key.Escape, _, _) => {
        tablero.estado = Tablero.Menu
      }
    }

    focusable = true
    requestFocus
  }

  new Thread(new Updater(tablero, canvas, puntaje)).start

}

class Updater(val tablero: Tablero, val panel: PanelTablero, val panelPuntaje: PanelPuntos) extends Runnable {

  def run() {
    while (true) {
      if (tablero.estado == Tablero.Jugando) {
        if (tablero.avanzar) {
          panelPuntaje.actualizarPuntos(tablero.puntos)
        } else {
          tablero.estado = Tablero.Perdio
          if (tablero.esTopScore()) {
            val r = Dialog.showInput(panel, "Indique su nombre", "¡Top Score!", Dialog.Message.Question, null, (""), "nn" + tablero.puntos)
            r match {
              case Some(s) => tablero.guardarTopScore(s toString)
              case None    =>
            }
          }
        }
      }
      panel.repaint
      Thread.sleep(tablero.darVelocidadRefresco)
    }
  }
}