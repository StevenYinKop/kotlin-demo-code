package cc.stevenyin.actioninkotlin.chapter02._02_20

import cc.stevenyin.actioninkotlin.chapter02._02_17.Expr
import cc.stevenyin.actioninkotlin.chapter02._02_17.Num
import cc.stevenyin.actioninkotlin.chapter02._02_17.Sum

class Eval
// 使用when代替了if
fun eval(e: Expr): Int =
	when (e) {
		is Num -> e.value
		is Sum -> eval(e.right) + eval(e.left)
		else -> throw IllegalArgumentException("Unknown expression")
	}

fun main(args: Array<String>) {
	println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}
