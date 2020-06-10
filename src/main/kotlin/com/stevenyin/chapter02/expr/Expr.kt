package com.stevenyin.chapter02.expr

interface Expr

class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int {
	if (e is Num) { // 使用is来判断类型和Java中instanceOf类似
		return e.value
	}
	if (e is Sum) {
		return eval(e.left) + eval(e.right)
	}
	throw IllegalArgumentException("Unknown expression")
}
// 使用函数表达式来替换之前的花括号+return的语法
fun eval2(e: Expr): Int =
	if (e is Num) {
		e.value
	} else if (e is Sum) {
		eval2(e.left) + eval2(e.right)
	} else {
		throw IllegalArgumentException("Unknown expression")
	}
// 使用when来代替if
fun eval3(e: Expr): Int = when (e) {
	is Num -> e.value
	is Sum -> eval3(e.left) + eval3(e.right)
	else -> throw IllegalArgumentException("Unknown expression")
}
// 如果when的返回值里面, 不仅仅是一个结果, 还想有其他操作, 可以用花括号括起来
fun eval4(e: Expr): Int = when (e) {
	is Num -> {
		println("This is log, current Expr is Num, value = ${e.value}")
		e.value
	}
	is Sum -> {
		println("This is log, current Expr is Sum")
		eval4(e.left) + eval4(e.right)
	}
	else -> {
		println("Oops, This is unknown Type, throw")
		throw IllegalArgumentException("Unknown expression")
	}
}
fun main() {
	println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
	println(eval2(Sum(Sum(Num(1), Num(2)), Num(4))))
	println(eval3(Sum(Sum(Num(1), Num(2)), Num(4))))
	println(eval4(Sum(Sum(Num(1), Num(2)), Num(4))))
}