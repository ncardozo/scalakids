package culebrita.mundo

import scala.util.Random
import java.io.PrintWriter
import java.io.File
import scala.io.Source
import java.io.FileNotFoundException

object Tablero {
  val Norte = 0
  val Este = 1
  val Sur = 2
  val Oeste = 3

  val Detenido = 0
  val Jugando = 1
  val Perdio = 2
  val Pausa = 3
  val Menu = 4
  val Top10 = 5

  val Jugar = 11

  val archivoTopScore = "./data/topScore.txt"
}

class Tablero(val ancho: Int, val alto: Int) {

  var estado: Int = Tablero.Menu
  var manzana: Manzana = _
  var puntos: Int = _
  var culebrita: Culebrita = _
  var velocidad: Int = 2
  var top10: List[TopScore] = cargarArchivoTopScore()
  var opcionSeleccionada: Int = Tablero.Jugar

  def iniciarJuego() = {
    generarCulebrita()
    generarNuevaManzana()
  }

  def darVelocidadRefresco(): Int = {
    velocidad match {
      case 1 => 200
      case 2 => 100
      case 3 => 50
    }
  }

  def generarCulebrita() = {
    estado = Tablero.Detenido
    puntos = 0
    var x = Random.nextInt(ancho)
    var y = Random.nextInt(alto)
    var direccion = Tablero.Norte
    culebrita = new Culebrita(x, y, direccion)
  }

  def generarNuevaManzana() = {
    var xManzana = Random.nextInt(ancho);
    var yManzana = Random.nextInt(alto);

    while (colision(xManzana, yManzana)) {
      xManzana = Random.nextInt(ancho);
      yManzana = Random.nextInt(alto);
    }

    manzana = new Manzana(xManzana, yManzana)
  }

  def girar(dir: Int): Unit = {
    if (estado == Tablero.Detenido || estado == Tablero.Jugando) {
      estado = Tablero.Jugando
      culebrita.girar(dir)
    }
  }

  def avanzar(): Boolean = {
    if (comioManzana) {
      puntos += velocidad * velocidad
      culebrita.crecer()
      generarNuevaManzana()
    } else if (colisionCuerpo || colisionBorde) {
      estado = Tablero.Perdio
    }
    if (estado == Tablero.Jugando) {
      culebrita.avanzar()
    }
    estado == Tablero.Jugando
  }

  def comioManzana: Boolean = {
    var cabeza = culebrita.darCabeza()
    cabeza.x == manzana.xManzana && cabeza.y == manzana.yManzana
  }

  def colisionCuerpo: Boolean = {
    var cabeza = culebrita.darCabeza()
    colision(cabeza.x, cabeza.y, culebrita.cuerpo.tail)
  }

  def colisionBorde: Boolean = {
    var cabeza = culebrita.darCabeza()
    (cabeza.x == 0 && culebrita.direccion == Tablero.Oeste) ||
      (cabeza.x == ancho - 1 && culebrita.direccion == Tablero.Este) ||
      (cabeza.y == 0 && culebrita.direccion == Tablero.Norte) ||
      (cabeza.y == alto - 1 && culebrita.direccion == Tablero.Sur)
  }

  def colision(x: Int, y: Int, parte: List[ParteCulebrita]): Boolean = {
    parte match {
      case Nil        => false
      case c :: resto => (c.x == x && c.y == y) || colision(x, y, resto)
    }
  }

  def colision(x: Int, y: Int): Boolean = {
    colision(x, y, culebrita.cuerpo)
  }

  def esTopScore(): Boolean = {
    top10.isEmpty || top10.length < 10 || top10.last.puntos < puntos
  }

  def guardarTopScore(nombre: String): Unit = {
    var newScore = new TopScore(nombre, puntos)
    if (top10.length < 10)
      top10 = newScore :: top10
    else if (top10.last.puntos < puntos)
      top10 = newScore :: top10.dropRight(1)

    top10 = top10.sortWith((t1, t2) => {
      t1.puntos > t2.puntos
    })

    guardarArchivoTopScore()
  }

  def guardarArchivoTopScore(): Unit = {
    val pw = new PrintWriter(new File(Tablero.archivoTopScore))
    top10.foreach((ts) => if (ts != null) pw.println(ts.nombre + "***" + ts.puntos))
    pw.close()
  }

  def cargarArchivoTopScore(): List[TopScore] = {
    var scores: List[TopScore] = List()
    try {
      for (line <- Source.fromFile(Tablero.archivoTopScore).getLines()) {
        var parts = line.split("===")
        scores = (new TopScore(parts(0), parts(1).toInt)) :: scores
      }
      scores.sortWith((t1, t2) => {
        t1.puntos > t2.puntos
      })
    } catch {
      case ex: FileNotFoundException => println("No hay datos"); List()
    }
  }

}