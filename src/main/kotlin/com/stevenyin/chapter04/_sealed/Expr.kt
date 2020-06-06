package com.stevenyin.chapter04._sealed

sealed class Expr {
	class Num(val value: Int): Expr()
	class Sum(val left: Expr, val right: Expr): Expr()
}

fun eval(e: Expr): Int =
	when(e) {
		is Expr.Num -> e.value
		is Expr.Sum -> eval(e.left) + eval(e.right)
	}