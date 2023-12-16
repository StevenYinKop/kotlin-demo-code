//import cc.stevenyin.algorithms._02_sorts.ISortAlgorithm
//import cc.stevenyin.algorithms._02_sorts._01_SelectionISort
//import cc.stevenyin.algorithms._02_sorts.visualizer.AlgoFrame
//import cc.stevenyin.algorithms._02_sorts.visualizer.AlgoVisHelper
//import cc.stevenyin.algorithms.generateIntegerTestCases
//import java.awt.EventQueue
//
//class AlgoVisualizer(val data: Array<Int>, val clz: ISortAlgorithm) {
//
//    private val DELAY: Int = 10
//    private lateinit var frame: AlgoFrame // View
//
//    init {
//        EventQueue.invokeLater {
//            frame = AlgoFrame(clz.name)
//            Thread {
//                run()
//            }.start()
//        }
//    }
//
//    private fun run() {
//        frame.render(data)
//        AlgoVisHelper.pause(DELAY)
//        clz.sort(data)
//        {
//            frame.render(it)
//            AlgoVisHelper.pause(DELAY)
//        }
//        frame.render(data)
//        AlgoVisHelper.pause(DELAY)
//    }
//}
//
//fun main() {
//    val testCases = generateIntegerTestCases(50, maximum = 700)
//    AlgoVisualizer(testCases, _01_SelectionISort())
//}
