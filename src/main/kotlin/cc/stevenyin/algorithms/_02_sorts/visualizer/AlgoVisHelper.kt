//package cc.stevenyin.algorithms._02_sorts.visualizer
//
//import java.awt.BasicStroke
//import java.awt.Color
//import java.awt.Graphics2D
//import java.awt.geom.Ellipse2D
//import java.awt.geom.Rectangle2D
//import javax.swing.ImageIcon
//
//object AlgoVisHelper {
//
//    val Red: Color = Color(0xF44336)
//    val Pink: Color = Color(0xE91E63)
//    val Purple: Color = Color(0x9C27B0)
//    val DeepPurple: Color = Color(0x673AB7)
//    val Indigo: Color = Color(0x3F51B5)
//    val Blue: Color = Color(0x2196F3)
//    val LightBlue: Color = Color(0x03A9F4)
//    val Cyan: Color = Color(0x00BCD4)
//    val Teal: Color = Color(0x009688)
//    val Green: Color = Color(0x4CAF50)
//    val LightGreen: Color = Color(0x8BC34A)
//    val Lime: Color = Color(0xCDDC39)
//    val Yellow: Color = Color(0xFFEB3B)
//    val Amber: Color = Color(0xFFC107)
//    val Orange: Color = Color(0xFF9800)
//    val DeepOrange: Color = Color(0xFF5722)
//    val Brown: Color = Color(0x795548)
//    val Grey: Color = Color(0x9E9E9E)
//    val BlueGrey: Color = Color(0x607D8B)
//    val Black: Color = Color(0x000000)
//    val White: Color = Color(0xFFFFFF)
//
//    fun strokeCircle(g: Graphics2D, x: Int, y: Int, r: Int) {
//        val circle = Ellipse2D.Double(x - r.toDouble(), y - r.toDouble(), 2 * r.toDouble(), 2 * r.toDouble())
//        g.draw(circle)
//    }
//
//    fun fillCircle(g: Graphics2D, x: Int, y: Int, r: Int) {
//        val circle = Ellipse2D.Double(x - r.toDouble(), y - r.toDouble(), 2 * r.toDouble(), 2 * r.toDouble())
//        g.fill(circle)
//    }
//
//    fun strokeRectangle(g: Graphics2D, x: Int, y: Int, w: Int, h: Int) {
//        val rectangle = Rectangle2D.Double(x.toDouble(), y.toDouble(), w.toDouble(), h.toDouble())
//        g.draw(rectangle)
//    }
//
//    fun fillRectangle(g: Graphics2D, x: Int, y: Int, w: Int, h: Int) {
//        val rectangle = Rectangle2D.Double(x.toDouble(), y.toDouble(), w.toDouble(), h.toDouble())
//        g.fill(rectangle)
//    }
//
//    fun setColor(g: Graphics2D, color: Color) {
//        g.color = color
//    }
//
//    fun setStrokeWidth(g: Graphics2D, w: Int) {
//        val strokeWidth = w
//        g.stroke = BasicStroke(strokeWidth.toFloat(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)
//    }
//
//    fun pause(t: Int) {
//        try {
//            Thread.sleep(t.toLong())
//        } catch (e: InterruptedException) {
//            println("Error sleeping")
//        }
//    }
//
//    fun putImage(g: Graphics2D, x: Int, y: Int, imageURL: String) {
//        val icon = ImageIcon(imageURL)
//        val image = icon.image
//        g.drawImage(image, x, y, null)
//    }
//
//    fun drawText(g: Graphics2D, text: String, centerx: Int, centery: Int) {
//        requireNotNull(text) { "Text is null in drawText function!" }
//        val metrics = g.fontMetrics
//        val w = metrics.stringWidth(text)
//        val h = metrics.descent
//        g.drawString(text, centerx - w / 2, centery + h)
//    }
//}
