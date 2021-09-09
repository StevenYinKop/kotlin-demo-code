package cc.stevenyin.design_pattern

class _01_13_CompositeReusePrinciple {
    interface ICar {
        fun run()
    }

    class Color(val colorName: String) {
        override fun toString() = colorName
    }

    open class GasCar(val color: Color) : ICar {
        override fun run() {
            println("${color}GasCar is running!")
        }
    }

    open class ElectricCar(val color: Color) : ICar {
        override fun run() {
            println("${color}ElectricCar is running!")
        }
    }
}

fun main() {
    val car1: _01_13_CompositeReusePrinciple.ICar = _01_13_CompositeReusePrinciple.GasCar(
        _01_13_CompositeReusePrinciple.Color("")
    )
    car1.run()
    val car2: _01_13_CompositeReusePrinciple.ICar = _01_13_CompositeReusePrinciple.ElectricCar(
        _01_13_CompositeReusePrinciple.Color("")
    )
    car2.run()
    val car3: _01_13_CompositeReusePrinciple.ICar = _01_13_CompositeReusePrinciple.GasCar(
        _01_13_CompositeReusePrinciple.Color("White")
    )
    car3.run()
    val car4: _01_13_CompositeReusePrinciple.ICar = _01_13_CompositeReusePrinciple.ElectricCar(
        _01_13_CompositeReusePrinciple.Color("White")
    )
    car4.run()
    val car5: _01_13_CompositeReusePrinciple.ICar = _01_13_CompositeReusePrinciple.GasCar(
        _01_13_CompositeReusePrinciple.Color("Black")
    )
    car5.run()
    val car6: _01_13_CompositeReusePrinciple.ICar = _01_13_CompositeReusePrinciple.ElectricCar(
        _01_13_CompositeReusePrinciple.Color("Black")
    )
    car6.run()
    val car7: _01_13_CompositeReusePrinciple.ICar = _01_13_CompositeReusePrinciple.GasCar(
        _01_13_CompositeReusePrinciple.Color("Red")
    )
    car7.run()
    val car8: _01_13_CompositeReusePrinciple.ICar = _01_13_CompositeReusePrinciple.ElectricCar(
        _01_13_CompositeReusePrinciple.Color("Red")
    )
    car8.run()

}