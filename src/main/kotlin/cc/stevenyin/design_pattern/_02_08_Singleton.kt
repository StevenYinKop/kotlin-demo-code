package cc.stevenyin.design_pattern

import java.io.Serializable

class _02_08_Singleton private /* 构造器私有化 */ constructor() : Serializable {

    fun doSomething() {
        println("do some thing")
    }

    private fun readResolve(): Any {//防止单例对象在反序列化时重新生成对象
        return instance
    }

    companion object {
        //使用lazy属性代理，并指定LazyThreadSafetyMode为SYNCHRONIZED模式保证线程安全
        val instance: _02_08_Singleton by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { _02_08_Singleton() }
    }
}

fun main(args: Array<String>) {
    repeat(10) {
        Thread {
            println("Thread name: " + Thread.currentThread() + ":" + _02_08_Singleton.instance)
        }.start()
    }
}