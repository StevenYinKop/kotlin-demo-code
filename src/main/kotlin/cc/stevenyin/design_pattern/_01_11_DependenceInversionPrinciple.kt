package cc.stevenyin.design_pattern

class _01_11_DependenceInversionPrinciple {
    interface IDriver {
        fun drive()
    }

    interface ICar {
        fun run()
    }

    class Driver : IDriver {
        lateinit var car: ICar
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
    val oldDriver = _01_11_DependenceInversionPrinciple.Driver()
    oldDriver.car = _01_11_DependenceInversionPrinciple.Benz()
    oldDriver.drive()
    oldDriver.car = _01_11_DependenceInversionPrinciple.Wuling()
    oldDriver.drive()
}