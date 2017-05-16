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

