package cc.stevenyin.design_pattern

class _01_12_CompositeReusePrinciple {
    interface ICar {
        fun run()
    }

    open class GasCar : ICar {
        override fun run() {
            println("GasCar is running!")
        }
    }

    open class ElectricCar : ICar {
        override fun run() {
            println("ElectricCar is running!")
        }
    }

    class WhiteElectricCar : ElectricCar() {
        override fun run() {
            println("WhiteElectricCar is running!")
        }
    }

    class BlackElectricCar : ElectricCar() {
        override fun run() {
            println("BlackElectricCar is running!")
        }
    }

    class RedElectricCar : ElectricCar() {
        override fun run() {
            println("RedElectricCar is running!")
        }
    }

    class WhiteGasCar : GasCar() {
        override fun run() {
            println("RedElectricCar is running!")
        }
    }

    class BlackGasCar : GasCar() {
        override fun run() {
            println("BlackGasCar is running!")
        }
    }

    class RedGasCar : GasCar() {
        override fun run() {
            println("RedGasCar is running!")
        }
    }
}

fun main() {
    val car1: _01_12_CompositeReusePrinciple.ICar = _01_12_CompositeReusePrinciple.GasCar()
    car1.run()
    val car2: _01_12_CompositeReusePrinciple.ICar = _01_12_CompositeReusePrinciple.ElectricCar()
    car2.run()
    val car3: _01_12_CompositeReusePrinciple.ICar = _01_12_CompositeReusePrinciple.WhiteElectricCar()
    car3.run()
    val car4: _01_12_CompositeReusePrinciple.ICar = _01_12_CompositeReusePrinciple.BlackElectricCar()
    car4.run()
    val car5: _01_12_CompositeReusePrinciple.ICar = _01_12_CompositeReusePrinciple.RedElectricCar()
    car5.run()
    val car6: _01_12_CompositeReusePrinciple.ICar = _01_12_CompositeReusePrinciple.WhiteGasCar()
    car6.run()
    val car7: _01_12_CompositeReusePrinciple.ICar = _01_12_CompositeReusePrinciple.BlackGasCar()
    car7.run()
    val car8: _01_12_CompositeReusePrinciple.ICar = _01_12_CompositeReusePrinciple.RedGasCar()
    car8.run()
}