package uniandes.cupi2.dogBook.mundo

import scala.util.Properties
import java.io.FileInputStream
import java.io.File
import java.util.Properties

class DogBookScala {

  private var perros: List[PerroScala] = List()

  private var perroActual: Int = 0;

  def buscarPerroPorNombre(nombrePerro: String) = {
      var elPerro = perros.find(_.nombre.equals(nombrePerro))
      elPerro match {
        case Some(p) => {
          perroActual = perros.indexOf(p)
          p
        }
        case None => None
      }
  }

  def darCantidadPerros = perros.length

  def darCantidadReaccionPerros(nombreReaccion: String) = {
    var reaccion = darPerroActual.darReaccion(nombreReaccion)
    reaccion match {
      case Some(r) => r.cantidad
      case None    => 0
    }
  }

  def darReaccionPerros(nombreReaccion: String) = {
    var reaccion = darPerroActual.darReaccion(nombreReaccion)
    reaccion match {
      case Some(r) => r
      case None    => null
    }
  }

  def darPerroActual = perros(perroActual)

  def darPerroAnterior = {
    if (perroActual == 0) {
      throw new Exception("Se encuentra en el primer perro. ");
    }
    perroActual -= 1;
    darPerroActual
  }

  def darPerroSiguiente = {
    if (perroActual == perros.length - 1) {
      throw new Exception("Se encuentra en el último perro. ");
    }
    perroActual += 1;
    darPerroActual
  }

  def darPrimerPerro = {
    if (perroActual == 0) {
      throw new Exception("Se encuentra en el primer perro. ");
    }
    perroActual = 0;
    darPerroActual
  }

  def darUltimoPerro = {
    if (perroActual == perros.length - 1) {
      throw new Exception("Se encuentra en el último perro. ");
    }
    perroActual = perros.length - 1;
    darPerroActual
  }

  def darPerroMasPopular = {
    perros.foldLeft(perros(0))((x: PerroScala, y: PerroScala) => { if (x.darCantidadReacciones >= y.darCantidadReacciones) x else y })
  }

  def reaccionar(nombreReaccion: String) = perros(perroActual).reaccionar(nombreReaccion)

  def metodo1 = "Opcion 1"

  def metodo2 = "Opcion 2"

  def cargarPerros(archivo: String) = {
    // Carga las propiedades
    val persistencia = new Properties();
    val fis = new FileInputStream(new File(archivo));
    persistencia.load(fis);
    fis.close();

    // Lee la cantidad de perros del archivo
    val cantidadPerros = persistencia.getProperty("dogBook.cantidadPerros").toInt

    for (i <- 1 to cantidadPerros) {
      val nombre = persistencia.getProperty("dogBook.perro" + i + ".nombre");
      val edad = persistencia.getProperty("dogBook.perro" + i + ".edad").toInt;
      val raza = persistencia.getProperty("dogBook.perro" + i + ".raza");
      val sexo = persistencia.getProperty("dogBook.perro" + i + ".sexo");
      val foto = persistencia.getProperty("dogBook.perro" + i + ".foto");
      val meGusta = persistencia.getProperty("dogBook.perro" + i + ".meGusta");
      val noMeGusta = persistencia.getProperty("dogBook.perro" + i + ".noMeGusta");
      val buscoPareja = persistencia.getProperty("dogBook.perro" + i + ".buscoPareja").equals("SI");

      // construir el perro
      val perro = new PerroScala(nombre, edad, raza, sexo, foto, meGusta, noMeGusta, buscoPareja);
      perros = perro :: perros
    }
    perros = perros.reverse

  }

  cargarPerros("./data/perros.data");

}