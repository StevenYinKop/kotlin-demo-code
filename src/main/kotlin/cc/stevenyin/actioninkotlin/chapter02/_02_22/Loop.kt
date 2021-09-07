package cc.stevenyin.actioninkotlin.chapter02._02_22

class Loop
// 使用when实现Fizz-Buzz游戏
fun fizzBuzz(i: Int) = when {
	i % 15 == 0 -> "FizzBuzz "
	i % 3 == 0 -> "Fizz "
	i % 5 == 0 -> "Buzz "
	else -> "$i "
}

fun main(args: Array<String>) {
	//	for (i in 0 until 100) // 等同于 for (i in 0..size - 1)
	for (i in 1 .. 100) {
		print(fizzBuzz(i))
	}
}
