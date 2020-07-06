package com.stevenyin.actioninkotlin.chapter02._02_21

import com.stevenyin.actioninkotlin.chapter02._02_17.Num
import com.stevenyin.actioninkotlin.chapter02._02_17.Expr
import com.stevenyin.actioninkotlin.chapter02._02_17.Sum
import java.lang.IllegalArgumentException

class Eval
// 使用分支中含有混合操作的when
fun evalWithLogging(e: Expr): Int =
	when (e) {
		is Num -> {
			println("num: ${e.value}")
			e.value
		}
		is Sum -> {
			val left = evalWithLogging(e.left)
			val right = evalWithLogging(e.right)
			println("sum: $left + $right")
			left + right
		}
		else -> throw IllegalArgumentException("Unknown expression")
	}

fun main(args: Array<String>) {
	println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}
