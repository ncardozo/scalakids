package uniandes.cupi2.dogBook.interfaz

import scala.swing.GridPanel
import scala.swing._
import java.awt.Color
import scala.swing.event.ButtonClicked

class PanelOpciones(principal: InterfazDogBook) extends GridPanel(1, 3) {

  border = Swing.TitledBorder(Swing.LineBorder(Color.LIGHT_GRAY), "Opciones")

  val butPerroPopular = new Button { text = "Perro más popular" }
  contents += butPerroPopular

  val butOpcion1 = new Button { text = "Opción 1" }
  contents += butOpcion1

  val butOpcion2 = new Button { text = "Opción 2" }
  contents += butOpcion2

  listenTo(butPerroPopular, butOpcion1, butOpcion2)
  reactions += {
    case ButtonClicked(`butPerroPopular`) => {
      val perroMasPopular = principal.perroPopular
      Dialog.showMessage(contents.head, perroMasPopular.nombre, title = "Perro más popular")
    }
    case ButtonClicked(`butOpcion1`) => {
      Dialog.showMessage(contents.head, principal.opcion1, title = "Opción 1")
    }
    case ButtonClicked(`butOpcion2`) => {
      Dialog.showMessage(contents.head, principal.opcion2, title = "Opción 2")
    }
  }
}