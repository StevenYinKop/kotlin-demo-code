package cc.stevenyin.design_pattern

enum class _02_10_Singleton {
    INSTANCE;

    fun doSomeThing() {
        println("do some thing")
    }

    override fun toString(): String {
        return javaClass.name + "@" + Integer.toHexString(hashCode())
    }
}

fun main(args: Array<String>) {
    repeat(10) {
        Thread {
            println("Thread name: " + Thread.currentThread() + ":" + _02_10_Singleton.INSTANCE)
        }.start()
    }
}