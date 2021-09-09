package cc.stevenyin.design_pattern

class _01_09_DependenceInversionPrinciple {
    interface IDriver {
        fun drive(car: ICar)
    }

    interface ICar {
        fun run()
    }

    class Driver : IDriver {
        override fun drive(car: ICar) = car.run()
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
    val oldDriver = _01_09_DependenceInversionPrinciple.Driver()
    oldDriver.drive(_01_09_DependenceInversionPrinciple.Benz())
    oldDriver.drive(_01_09_DependenceInversionPrinciple.Wuling())
}