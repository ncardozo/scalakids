package uniandes.cupi2.dogBook.mundo

object ReaccionScala {
  // -----------------------------------------------------------------
  // Constantes
  // -----------------------------------------------------------------
  /**
   *
   * Constante que representa la reacción me gusta.
   */
  val ME_GUSTA = "Me gusta";

  /**
   * Constante que representa la reacción corazón.
   */
  val CORAZON = "Corazón";

  /**
   * Constante que representa la reacción cara feliz.
   */
  val CARA_FELIZ = "Cara feliz";

}

class ReaccionScala(val nombre: String) {
  var cantidad = 0

  def darNombre = nombre
  def darCantidad = cantidad
  def aumentarCantidad = cantidad += 1

}