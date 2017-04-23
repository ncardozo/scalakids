package uniandes.cupi2.dogBook.interfaz

import scala.swing._
import scala.swing.BorderPanel.Position._
import java.awt.Color
import javax.swing.ImageIcon
import uniandes.cupi2.dogBook.mundo._
import scala.swing.event.ButtonClicked

class PanelInformacion(principal: InterfazDogBook) extends BorderPanel {

  border = Swing.TitledBorder(Swing.LineBorder(Color.BLACK), "Información perro")

  val panelPerro = new PanelPerro(principal)
  val panelDatos = new PanelDatos
  val panelNavegacion = new PanelNavegacion(principal);

  layout(panelDatos) = East
  layout(panelPerro) = Center
  layout(panelNavegacion) = South

  def mostrarPerro(perro: PerroScala) = {
    panelPerro.mostrarPerro(perro)
    panelDatos.mostrarPerro(perro)
  }

}