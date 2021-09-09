package cc.stevenyin.design_pattern

class _01_08_DependenceInversionPrinciple {
    class Driver {
        fun drive(benz: Benz) = benz.run()
    }

    class Benz {
        fun run() {
            println("Benz is running")
        }
    }
}

fun main() {
    val oldDriver = _01_08_DependenceInversionPrinciple.Driver()
    oldDriver.drive(_01_08_DependenceInversionPrinciple.Benz())
}