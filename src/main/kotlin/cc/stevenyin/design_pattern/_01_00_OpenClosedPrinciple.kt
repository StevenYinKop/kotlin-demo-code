package cc.stevenyin.design_pattern

fun main() {
    GraphicEditor().drawShape(Rectangle())
    GraphicEditor().drawShape(Circle())
    GraphicEditor().drawShape(Triangle())
}

class GraphicEditor {
    fun drawShape(shape: Shape) {
        when (shape.type) {
            1 -> drawRectangle()
            2 -> drawCircle()
            3 -> drawTriangle()
            else -> drawBlank()
        }
    }

    fun drawRectangle() {
        println("绘制矩形")
    }

    fun drawCircle() {
        println("绘制圆形")
    }

    fun drawTriangle() {
        println("绘制三角形")
    }

    fun drawBlank() {
        println("传入的类型有误")
    }
}

open class Shape(val type: Int) {}
class Rectangle : Shape(1)
class Circle : Shape(2)
class Triangle : Shape(3)