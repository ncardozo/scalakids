package culebrita.interfaz

import scala.swing.Panel
import java.awt.Graphics2D
import java.awt.Color
import culebrita.mundo.Tablero
import java.awt.BasicStroke
import java.awt.Stroke
import java.awt.Font

class PanelTablero(val tablero: Tablero, val borde: Int, val escala: Int) extends Panel {
  val centerColor = Color.decode("#6B5E0B")
  val borderColor = Color.LIGHT_GRAY
  val fondoColor = Color.decode("#B2BF1F")
  val dashed = new BasicStroke(5.0f,
    BasicStroke.CAP_BUTT,
    BasicStroke.JOIN_MITER,
    5.0f, Array(5.0f, 1.0f), 2.5f)

  override def paintComponent(g: Graphics2D) {
    // pintarTablero(g)
    if (tablero.estado == Tablero.Menu) {
      pintarMenu(g)
    } else if (tablero.estado == Tablero.Top10) {
      pintarTop10(g)
    } else if (tablero.estado == Tablero.Perdio) {
      pintarPerdio(g)
    } else if (tablero.estado == Tablero.Pausa) {
      pintarPausa(g)
    } else pintarTablero(g)

  }

  def pintarTablero(g: Graphics2D) = {
    pintarBase(g)

    if (tablero.culebrita != null) {
      var culebrita = tablero.culebrita.cuerpo
      culebrita.foreach((c) => {
        g.setColor(borderColor)
        g.drawRect(c.x * escala + borde, c.y * escala + borde, escala, escala)
        g.setColor(centerColor)
        g.fillRect(c.x * escala + borde, c.y * escala + borde, escala, escala)
      })
    }

    if (tablero.manzana != null) {
      var manzana = tablero.manzana
      g.setStroke(new BasicStroke(3));
      g.setColor(centerColor)
      g.drawOval((manzana.xManzana * escala) + 1 + borde, (manzana.yManzana * escala) + 1 + borde, escala - 3, escala - 3)
    }

    g.setColor(centerColor)
    g.setFont(new Font("Press Start 2P", java.awt.Font.BOLD, 12))
    g.drawString("" + tablero.velocidad, 15, size.height - 15)

  }

  def pintarMenu(g: Graphics2D) = {
    pintarBase(g)

    g.setColor(centerColor)
    g.fillRect(50, 50, size.width - 100, size.height - 100)

    g.setFont(new Font("Press Start 2P", java.awt.Font.BOLD, 24))

    if (tablero.opcionSeleccionada == Tablero.Top10) {
      g.setColor(fondoColor)
      g.drawRect(100, 90, 220, 50)
      g.drawString("Jugar", 160, 130)

      g.setColor(fondoColor)
      g.fillRect(100, 220, 220, 50)

      g.setColor(centerColor)
      g.drawString("Top 10", 140, 260)
    } else {
      g.setColor(fondoColor)
      g.fillRect(100, 90, 220, 50)
      g.setColor(centerColor)
      g.drawString("Jugar", 160, 130)

      g.setColor(fondoColor)
      g.drawRect(100, 220, 220, 50)
      g.drawString("Top 10", 140, 260)

    }
  }

  def pintarTop10(g: Graphics2D) = {
    pintarBase(g)

    g.setColor(centerColor)
    g.fillRect(20, 20, size.width - 40, size.height - 40)

    g.setColor(fondoColor)
    g.setFont(new Font("Press Start 2P", java.awt.Font.BOLD, 24))
    g.drawString("Top 10", 140, 50)

    // g.setColor(centerColor)
    g.setFont(new Font("Press Start 2P", java.awt.Font.BOLD, 18))

    var posY = 80
    var num = 1

    tablero.top10.foreach((ts) => {
      var puntos = ts.puntos
      g.drawString(f"$num%2d " + ts.nombre, 30, posY)
      g.drawString(f"$puntos%03d", size.width - 80, posY)
      posY += 30
      num += 1
    })
  }

  def pintarBase(g: Graphics2D) = {
    g.clearRect(0, 0, size.width, size.height)
    g.setColor(fondoColor)
    g.fillRect(0, 0, size.width, size.height)
    g.setStroke(dashed)
    g.setColor(centerColor)
    g.drawRect(borde - 4, borde - 4, size.width - borde * 2 + 7, size.height - borde * 2 + 7)
    g.setStroke(new BasicStroke(2));
  }

  def pintarPerdio(g: Graphics2D) = {
    pintarTablero(g)

    g.setColor(centerColor)
    g.fillRect(50, 100, size.width - 100, size.height - 200)

    g.setColor(fondoColor)
    g.setFont(new Font("Press Start 2P", java.awt.Font.BOLD, 24))
    g.drawString("Perdiste", 110, 180)

    g.setColor(fondoColor)
    g.fillRect(170, 220, 70, 50)

    g.setColor(centerColor)
    g.drawString("Ok", 180, 260)
  }

  def pintarPausa(g: Graphics2D) = {
    pintarTablero(g)

    g.setColor(centerColor)
    g.fillRect(50, 100, size.width - 100, size.height - 200)

    g.setColor(fondoColor)
    g.setFont(new Font("Press Start 2P", java.awt.Font.BOLD, 24))
    g.drawString("Pausa", 140, 180)

    g.setColor(fondoColor)
    g.fillRect(170, 220, 70, 50)

    g.setColor(centerColor)
    g.drawString("Ok", 180, 260)
  }
}