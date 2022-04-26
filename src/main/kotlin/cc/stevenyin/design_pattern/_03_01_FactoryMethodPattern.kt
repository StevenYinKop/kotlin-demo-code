package cc.stevenyin.design_pattern

class _03_01_FactoryMethodPattern {
    interface ICarFactory {
        fun <T : ICar> create(clz: Class<T>): T
    }

    interface ICar {
        fun run()
    }

    class CarFactory : ICarFactory {
        override fun <T : ICar> create(clz: Class<T>): T {
            try {
                return Class.forName(clz.name).getDeclaredConstructor().newInstance() as T
            } catch (e: Exception) {
                println("无法识别的汽车类型: $clz")
                throw e
            }
        }
    }

    class BMW : ICar {
        override fun run() = println("我是一辆宝马 => @${Integer.toHexString(hashCode())}")
    }

    class Benz : ICar {
        override fun run() = println("我是一辆奔驰 => @${Integer.toHexString(hashCode())}")
    }

    class Wuling : ICar {
        override fun run() = println("我是一辆五菱宏光 => @${Integer.toHexString(hashCode())}")
    }

}

fun main() {
    val carFactory = _03_01_FactoryMethodPattern.CarFactory()
    val bmw = carFactory.create(_03_01_FactoryMethodPattern.BMW::class.java)
    val benz = carFactory.create(_03_01_FactoryMethodPattern.Benz::class.java)
    val wuling = carFactory.create(_03_01_FactoryMethodPattern.Wuling::class.java)
    bmw.run();
    benz.run();
    wuling.run();
}