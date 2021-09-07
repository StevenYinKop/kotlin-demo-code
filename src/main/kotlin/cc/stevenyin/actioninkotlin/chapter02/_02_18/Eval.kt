package cc.stevenyin.actioninkotlin.chapter02._02_18

import cc.stevenyin.actioninkotlin.chapter02._02_17.Expr
import cc.stevenyin.actioninkotlin.chapter02._02_17.Num
import cc.stevenyin.actioninkotlin.chapter02._02_17.Sum

class Eval
// 使用if层叠对表达式求值
fun eval(e: Expr): Int {
	if (e is Num) {
		val n = e as Num
		return n.value
	}
	if (e is Sum) {
		return eval(e.right) + eval(e.left)
	}
	throw IllegalArgumentException("Unknown expression")
}

fun main(args: Array<String>) {
	println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
}
