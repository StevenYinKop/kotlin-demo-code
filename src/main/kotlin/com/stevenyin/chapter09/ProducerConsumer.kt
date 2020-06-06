package com.stevenyin.chapter09

open class Fruit
open class Apple: Fruit()
class ApplePear: Apple()

/**
 * Kotlin: 声明处协变; Java: 使用处协变
 Kotlin中的out关键字叫做variance annotation, 因为它是在类型参数声明处所指定的, 因此我们称之为声明处协变(declaration-site variance).
 对于Java来说则是使用处协变(use-site variance), 其中类型通配符使得类型协变成为可能
 */

/**
 如果泛型类只是将泛型类型作为其方法的输出类型, 那么我们就可以使用out
 produce = output = out
 */
interface Producer<out T> {
	fun produce(): T
}
/**
 如果泛型类只是将泛型类型作为其方法的输入类型,那么我们就可以使用in
 
 consume = input = in
 */
interface Consumer<in T> {
	fun consume(t: T)
}

/**
 如果泛型类同时将泛型类型作为其方法的输入类型和输出类型, 那么我们就不能用out与in来修饰泛型
 */
interface ProducerConsumer<T> {
	fun produce(): T
	fun consume(t: T)
}

class FruitProducer: Producer<Fruit> {
	override fun produce(): Fruit {
		println("produce Fruit")
		return Fruit()
	}
}
class AppleProducer: Producer<Apple> {
	override fun produce(): Apple {
		println("produce Apple")
		return Apple()
	}
}
class ApplePearProducer: Producer<ApplePear> {
	override fun produce(): ApplePear {
		println("produce ApplePear")
		return ApplePear()
	}
}

fun main() {
	val produce1: Producer<Fruit> = FruitProducer()
	val produce2: Producer<Fruit> = AppleProducer() // Producer<Apple>
	val produce3: Producer<Fruit> = ApplePearProducer() // Producer<ApplePear>
	
}