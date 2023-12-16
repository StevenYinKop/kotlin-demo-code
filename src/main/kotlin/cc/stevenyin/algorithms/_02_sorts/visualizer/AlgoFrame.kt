//package cc.stevenyin.algorithms._02_sorts.visualizer
//
//import java.awt.Dimension
//import java.awt.Graphics
//import java.awt.Graphics2D
//import java.awt.RenderingHints
//import javax.swing.JFrame
//import javax.swing.JPanel
//
//class AlgoFrame(title: String, private val canvasWidth: Int, private val canvasHeight: Int) : JFrame(title) {
//
//    private lateinit var data: Array<Int>
//
//    init {
//        val canvas = AlgoCanvas()
//        contentPane = canvas
//        isResizable = false
//        pack()
//        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
//        isVisible = true
//    }
//
//    constructor(title: String) : this(title, 1024, 768)
//
//    fun getCanvasWidth() = canvasWidth
//    fun getCanvasHeight() = canvasHeight
//
//    // Set your own data
//    fun render(data: Array<Int>) {
//        this.data = data
//        repaint()
//    }
//
//    private inner class AlgoCanvas : JPanel(true) {
//
//        init {
//            // Double buffering
//            isDoubleBuffered = true
//        }
//
//        override fun paintComponent(g: Graphics) {
//            super.paintComponent(g)
//            val g2d = g as Graphics2D
//
//            // Antialiasing
//            val hints = RenderingHints(
//                RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON
//            )
//            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)
//            g2d.addRenderingHints(hints)
//
//            val w = canvasWidth / data.size
//            AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue)
//            for (i in data.indices) {
//                AlgoVisHelper.fillRectangle(g2d,
//                    i * w,
//                    canvasHeight - data[i],
//                    w - 1,
//                    data[i]
//                );
//            }
//        }
//
//        override fun getPreferredSize(): Dimension {
//            return Dimension(canvasWidth, canvasHeight)
//        }
//    }
//}
