package cc.stevenyin.design_pattern

object Singleton

fun main() {
    repeat(10) {
        Thread {
            println("Thread name: " + Thread.currentThread() + ":" + Singleton)
        }.start()
    }
}