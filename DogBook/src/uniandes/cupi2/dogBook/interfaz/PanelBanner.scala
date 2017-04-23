package uniandes.cupi2.dogBook.interfaz

import scala.swing._
import scala.swing.BorderPanel.Position._
import javax.swing.ImageIcon

class PanelBanner extends BorderPanel{
  val label = new Label {
    verticalTextPosition = Alignment.Bottom
    horizontalTextPosition = Alignment.Center
    horizontalAlignment = Alignment.Center
    border = Swing.EmptyBorder(0)
    icon = new  ImageIcon("./data/imagenes/titulo.jpg")
  }
  
  layout(label) = Center
  
}