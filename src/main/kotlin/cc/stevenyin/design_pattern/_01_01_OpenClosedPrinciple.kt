package cc.stevenyin.design_pattern

fun main() {
    GraphicEditor2().drawShape(Rectangle2())
    GraphicEditor2().drawShape(Circle2())
    GraphicEditor2().drawShape(Triangle2())
}

class GraphicEditor2 {
    fun drawShape(shape: Shape2) {
        shape.draw()
    }
}

abstract class Shape2(val type: Int) {
    open fun draw() {
        println("传入的类型有误")
    }
}

class Rectangle2 : Shape2(1) {
    override fun draw() {
        println("绘制矩形")
    }
}

class Circle2 : Shape2(2) {
    override fun draw() {
        println("绘制圆形")
    }
}

class Triangle2 : Shape2(3) {
    override fun draw() {
        println("绘制三角形")
    }
}