package cc.stevenyin.design_pattern

import java.io.Serializable

class _02_09_Singleton private /* 构造器私有化 */ constructor() : Serializable {

    fun doSomething() {
        println("do some thing")
    }

    private fun readResolve(): Any {//防止单例对象在反序列化时重新生成对象
        return SingletonHolder.instance
    }

    companion object {
        fun getInstance(): _02_09_Singleton {//全局访问点
            return SingletonHolder.instance
        }
    }

    private object SingletonHolder {
        //静态内部类
        val instance = _02_09_Singleton()
    }
}

fun main(args: Array<String>) {
    repeat(10) {
        Thread {
            println("Thread name: " + Thread.currentThread() + ":" + _02_09_Singleton.getInstance())
        }.start()
    }
}