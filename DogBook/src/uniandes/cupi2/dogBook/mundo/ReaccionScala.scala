package uniandes.cupi2.dogBook.mundo

object ReaccionScala {
  // -----------------------------------------------------------------
  // Constantes
  // -----------------------------------------------------------------
  /**
   *
   * Constante que representa la reacci�n me gusta.
   */
  val ME_GUSTA = "Me gusta";

  /**
   * Constante que representa la reacci�n coraz�n.
   */
  val CORAZON = "Coraz�n";

  /**
   * Constante que representa la reacci�n cara feliz.
   */
  val CARA_FELIZ = "Cara feliz";

}

class ReaccionScala(val nombre: String) {
  var cantidad = 0

  def darNombre = nombre
  def darCantidad = cantidad
  def aumentarCantidad = cantidad += 1

}