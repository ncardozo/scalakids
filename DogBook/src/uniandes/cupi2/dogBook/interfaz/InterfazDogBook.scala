package uniandes.cupi2.dogBook.interfaz

import scala.swing._
import java.awt.Color
import uniandes.cupi2.dogBook.mundo._

object InterfazDogBook extends SimpleSwingApplication {
  
  val dogBook = new DogBookScala
  dogBook.cargarPerros("./data/perros.data");
  
  def top: Frame = new InterfazDogBook(dogBook) {
    title = "DogBook"
  }
  
}

class InterfazDogBook(mundo: DogBookScala) extends MainFrame {
  val panelInformacion = new PanelInformacion(this)
  val panelOpciones = new PanelOpciones(this)

  contents = new BoxPanel(Orientation.Vertical) {
    contents += new PanelBanner
    contents += panelInformacion
    contents += panelOpciones
  }

  mostrarPerroActual
  pack

  def mostrarPerroActual = {
    val perro: PerroScala = mundo.darPerroActual
    panelInformacion.mostrarPerro(perro)
  }

  def perroPopular = {
    mundo.darPerroMasPopular
  }

  def opcion1 = {
    mundo.metodo1
  }

  def opcion2 = {
    mundo.metodo2
  }

  def like = {
    mundo.reaccionar(ReaccionScala.ME_GUSTA)
    mostrarPerroActual
  }

  def love = {
    mundo.reaccionar(ReaccionScala.CORAZON)
    mostrarPerroActual
  }

  def happy = {
    mundo.reaccionar(ReaccionScala.CARA_FELIZ)
    mostrarPerroActual
  }

  def primero = {
    try {
      mundo.darPrimerPerro
      mostrarPerroActual
    } catch {
      case ex: Exception => Dialog.showMessage(contents.head, ex.getMessage, title = "Error", Dialog.Message.Error)
    }
  }

  def anterior = {
    try {
      mundo.darPerroAnterior
      mostrarPerroActual
    } catch {
      case ex: Exception => Dialog.showMessage(contents.head, ex.getMessage, title = "Error", Dialog.Message.Error)
    }
  }

  def siguiente = {
    try {
      mundo.darPerroSiguiente
      mostrarPerroActual
    } catch {
      case ex: Exception => Dialog.showMessage(contents.head, ex.getMessage, title = "Error", Dialog.Message.Error)
    }
  }

  def buscar = {
    try {
      val r = Dialog.showInput(contents.head, "Indique el nombre del perro", initial = "nombre")
      r match {
        case Some(s) => {
          mundo.buscarPerroPorNombre(s)
          mostrarPerroActual
        }
        case None =>
      }
    } catch {
      case ex: Exception => Dialog.showMessage(contents.head, ex.getMessage, title = "Error", Dialog.Message.Error)
    }
  }

  def ultimo = {
    try {
      mundo.darUltimoPerro
      mostrarPerroActual
    } catch {
      case ex: Exception => Dialog.showMessage(contents.head, ex.getMessage, title = "Error", Dialog.Message.Error)
    }
  }

}