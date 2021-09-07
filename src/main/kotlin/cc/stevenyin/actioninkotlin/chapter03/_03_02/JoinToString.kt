package cc.stevenyin.actioninkotlin.chapter03._03_02

class JoinToString

// 声明带有默认参数的函数
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = cc.stevenyin.actioninkotlin.chapter03._03_01.joinToString(collection, separator, prefix, postfix)

fun main(args: Array<String>) {
	println(joinToString(listOf(1,2,3,4,5), ",", "[", "]"))
	println(joinToString(listOf(1,2,3,4,5)))
	println(joinToString(listOf(1,2,3,4,5), "."))
}