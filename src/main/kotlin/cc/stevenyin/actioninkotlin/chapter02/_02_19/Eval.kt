package cc.stevenyin.actioninkotlin.chapter02._02_19

import cc.stevenyin.actioninkotlin.chapter02._02_17.Expr
import cc.stevenyin.actioninkotlin.chapter02._02_17.Num
import cc.stevenyin.actioninkotlin.chapter02._02_17.Sum

class Eval
// 使用有返回值的if表达式
fun eval(e: Expr): Int = 
	if (e is Num) {
		val n = e as Num
		n.value
	} else if (e is Sum) {
		eval(e.right) + eval(e.left)
	} else {
		throw IllegalArgumentException("Unknown expression")
	}

fun main(args: Array<String>) {
	println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}
