package cc.stevenyin.actioninkotlin.chapter03._03_01

class JoinToString

fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {
	val result = StringBuilder(prefix)
	for((index, element) in collection.withIndex()) {
		if (index > 0) result.append(separator)
		result.append(element)
	}
	result.append(postfix)
	return result.toString()
}

fun main(args: Array<String>) {
	val list = listOf(1, 2, 3)
	println(joinToString(list, ",", "(", ")"))
	// 在调用Kotlin函数时, 可以显式标明一些参数的名称,
	// 如果在调用一个函数的时候指明了一个参数的名称, 为了避免混淆, 它之后所有的参数都要标明名称
	// Kotlin可以传参顺序和定义时不同, 但是前提是全部显式指明变量名, 不然就乱了
	println(joinToString(list, prefix = "(", postfix = ")", separator = ","))
}