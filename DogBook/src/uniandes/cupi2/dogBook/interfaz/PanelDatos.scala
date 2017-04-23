package uniandes.cupi2.dogBook.interfaz

import scala.swing.BorderPanel
import scala.swing.Label
import scala.swing._
import scala.swing.BorderPanel.Position._
import java.awt.Font
import scala.swing.GridPanel
import scala.swing.TextField
import scala.swing.Alignment
import javax.swing.border.EmptyBorder
import uniandes.cupi2.dogBook.mundo.PerroScala
import uniandes.cupi2.dogBook.mundo.PerroScala

class PanelDatos extends BorderPanel {

  border = Swing.EmptyBorder(0)

  val nombre = new Label {
    text = "nombre"
    font = font.deriveFont(40f)
    font = font.deriveFont(Font.BOLD)
    border = Swing.EmptyBorder(10, 0, 10, 0)
  }

  val txtEdad = new TextField { columns = 17; editable = false; enabled = false }
  val txtRaza = new TextField { columns = 17; editable = false; enabled = false }
  val txtSexo = new TextField { columns = 17; editable = false; enabled = false }
  val txtGusta = new TextField { columns = 17; editable = false; enabled = false }
  val txtNoMeGusta = new TextField { columns = 17; editable = false; enabled = false }
  val txtPareja = new CheckBox { enabled = false }

  val detalles = new GridPanel(7, 2) {
    contents += new Label { text = "Edad:"; horizontalTextPosition = Alignment.Left; horizontalAlignment = Alignment.Left }
    contents += txtEdad
    contents += new Label { text = "Raza:"; horizontalTextPosition = Alignment.Left; horizontalAlignment = Alignment.Left }
    contents += txtRaza
    contents += new Label { text = "Sexo:"; horizontalTextPosition = Alignment.Left; horizontalAlignment = Alignment.Left }
    contents += txtSexo
    contents += new Label { text = "Me gusta:"; horizontalTextPosition = Alignment.Left; horizontalAlignment = Alignment.Left }
    contents += txtGusta
    contents += new Label { text = "No me gusta:"; horizontalTextPosition = Alignment.Left; horizontalAlignment = Alignment.Left }
    contents += txtNoMeGusta
    contents += new Label { text = "Busco pareja:"; horizontalTextPosition = Alignment.Left; horizontalAlignment = Alignment.Left }
    contents += txtPareja
    contents += new Label
    contents += new Label
  }

  layout(nombre) = North
  layout(detalles) = Center

  def mostrarPerro(perro: PerroScala) = {
    nombre.text = perro.nombre
    txtEdad.text = perro.edad.toString()
    txtRaza.text = perro.raza
    txtSexo.text = perro.sexo
    txtGusta.text = perro.meGusta
    txtNoMeGusta.text = perro.noMeGusta
    txtPareja.selected = perro.buscoPareja
  }

}
