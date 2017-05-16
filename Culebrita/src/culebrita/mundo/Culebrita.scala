package culebrita.mundo

class Culebrita(val inicialX: Int, val inicialY: Int, var direccion: Int) {

  var cuerpo: List[ParteCulebrita] = List(new ParteCulebrita(inicialX, inicialY))

  def darCabeza(): ParteCulebrita = cuerpo(0)

  def avanzar(): Unit = {
    var nuevaCabeza = cuerpo.head.moverCabeza(direccion)
    cuerpo = nuevaCabeza :: cuerpo.dropRight(1)
  }

  def crecer(): Unit = {
    var cabeza = cuerpo(0)
    var last = List(cuerpo.last)
    cuerpo = cuerpo ::: last
  }

  def girar(dir: Int): Boolean = {
    cuerpo match {
      case Nil           => direccion = dir; true
      case cabeza :: Nil => direccion = dir; true
      case cabeza :: resto => {
        val pos = cabeza.siguientePosicion(dir)
        if (pos._1 == resto.head.x && pos._2 == resto.head.y) false
        else {
          direccion = dir
          true
        }
      }
    }

  }

}

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

