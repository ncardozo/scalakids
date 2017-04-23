package uniandes.cupi2.dogBook.interfaz

import scala.swing._
import java.awt.Color
import scala.swing.event.ButtonClicked

class PanelNavegacion(principal: InterfazDogBook)  extends GridPanel(1,5) {
  border = Swing.TitledBorder(Swing.LineBorder(Color.BLACK), "Navegación")
  
  val butPrimero = new Button { text = "Ver primer perro" }
  val butAnterior = new Button { text = "<<" }
  val butBuscar = new Button { text = "Buscar" }
  val butSiguiente = new Button { text = ">>" }
  val butUltimo = new Button { text = "Ver útimo perro" }
 
  listenTo(butPrimero, butAnterior, butBuscar, butSiguiente, butUltimo)
 
  contents += (butPrimero, butAnterior, butBuscar, butSiguiente, butUltimo)
  
  reactions += {
    case ButtonClicked(`butPrimero`) => {
      principal.primero
    }
    case ButtonClicked(`butAnterior`) => {
      principal.anterior
    }
    case ButtonClicked(`butBuscar`) => {
      principal.buscar
    }
    case ButtonClicked(`butSiguiente`) => {
      principal.siguiente
    }
    case ButtonClicked(`butUltimo`) => {
      principal.ultimo
    }
  }
}