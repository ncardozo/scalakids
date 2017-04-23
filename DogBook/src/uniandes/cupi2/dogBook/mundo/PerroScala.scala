package uniandes.cupi2.dogBook.mundo

class PerroScala(val nombre: String, val edad: Int, val raza: String, val sexo: String, val foto: String, val meGusta: String, val noMeGusta: String, val buscoPareja: Boolean) {

  private val reacciones = Array(
    new ReaccionScala(ReaccionScala.ME_GUSTA),
    new ReaccionScala(ReaccionScala.CORAZON),
    new ReaccionScala(ReaccionScala.CARA_FELIZ))

  def darCantidadReacciones = reacciones.foldLeft(0)(_ + _.cantidad)

  def darReaccion(nombreReaccion: String): Option[ReaccionScala] = reacciones.find(_.nombre.equals(nombreReaccion))
  def darReaccionJava(nombreReaccion: String): ReaccionScala = {
    val reaccion = reacciones.find(_.nombre.equals(nombreReaccion))
    reaccion match {
      case Some(r) => r
      case None    => null
    }
  }

  def reaccionar(nombreReaccion: String): Unit = {
    val reaccion: Option[ReaccionScala] = reacciones.find(_.nombre.equals(nombreReaccion))
    reaccion match {
      case Some(r) => r.aumentarCantidad
      case None    =>
    }
  }
}