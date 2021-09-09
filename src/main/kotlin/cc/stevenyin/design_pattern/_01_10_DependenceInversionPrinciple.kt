package cc.stevenyin.design_pattern

class _01_10_DependenceInversionPrinciple {
    interface IDriver {
        fun drive()
    }

    interface ICar {
        fun run()
    }

    class Driver(private val car: ICar) : IDriver {
        override fun drive() = car.run()
    }

    class Benz : ICar {
        override fun run() {
            println("Benz is running")
        }
    }

    class Wuling : ICar {
        override fun run() {
            println("五菱宏光在飘移")
        }
    }
}

fun main() {
    val oldDriver = _01_10_DependenceInversionPrinciple.Driver(_01_10_DependenceInversionPrinciple.Benz())
    oldDriver.drive()
}