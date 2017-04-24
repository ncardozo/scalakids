package uniandes.cupi2.dogBook.interfaz

import scala.swing._
import scala.swing.BorderPanel.Position._
import java.awt.Color
import javax.swing.ImageIcon
import uniandes.cupi2.dogBook.mundo._
import scala.swing.event.ButtonClicked
import javax.swing.border.EmptyBorder

class PanelPerro(principal: InterfazDogBook) extends BorderPanel {

  border = Swing.EmptyBorder(0)

  val imagen = new Label {
    border = Swing.EmptyBorder(0)
  }

  val botonLike = new Button {
    icon = new ImageIcon("./data/imagenes/me_gusta.png")
  }

  val botonLove = new Button {
    icon = new ImageIcon("./data/imagenes/corazon.png")
  }

  val botonHappy = new Button {
    icon = new ImageIcon("./data/imagenes/cara_feliz.png")
  }

  val labLikes = new Label { text = "0" }
  val labLove = new Label { text = "0" }
  val labHappy = new Label { text = "0" }

  val holder = new GridPanel(2, 5) {
    contents += (new Label, botonLike, botonLove, botonHappy, new Label, new Label, labLikes, labLove, labHappy, new Label)
  }

  layout(imagen) = Center
  layout(holder) = South

  def mostrarPerro(perro: PerroScala) = {
    imagen.icon = new ImageIcon("./data/imagenes/" + perro.foto)

    labLikes.text = perro.darReaccion(ReaccionScala.ME_GUSTA).get.darCantidad.toString
    labLove.text = perro.darReaccion(ReaccionScala.CORAZON).get.darCantidad.toString
    labHappy.text = perro.darReaccion(ReaccionScala.CARA_FELIZ).get.darCantidad.toString
  }

  listenTo(botonLike, botonLove, botonHappy)
  reactions += {
    case ButtonClicked(`botonLike`) => {
      principal.like
    }
    case ButtonClicked(`botonLove`) => {
      principal.love
    }
    case ButtonClicked(`botonHappy`) => {
      principal.happy
    }
  }

}