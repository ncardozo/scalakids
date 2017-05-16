package culebrita.mundo

class ParteCulebrita(var x: Int, var y: Int) {

  def moverCabeza(direccion: Int): ParteCulebrita = {
    val pos = siguientePosicion(direccion)
    new ParteCulebrita(pos._1, pos._2)
  }

  def siguientePosicion(direccion: Int) : (Int, Int) = {
    direccion match {
      case Tablero.Norte => (x, y - 1)
      case Tablero.Este  => (x + 1, y)
      case Tablero.Sur   => (x, y + 1)
      case Tablero.Oeste => (x - 1, y)
    }
  }
  
}