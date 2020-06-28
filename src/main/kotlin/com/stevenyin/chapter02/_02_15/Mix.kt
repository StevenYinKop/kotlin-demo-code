package com.stevenyin.chapter02._02_15

import com.stevenyin.chapter02._02_11.Color
import com.stevenyin.chapter02._02_11.Color.*

class Mix
// Kotlin标准库中的setOf函数可以创建出Set, set这种集合顺序不重要只要两个set中包含一样的条目, 他们就是相等的
fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) { // "when"表达式的实参可以使任何对象, 它被检查是否与分支条件相等
	setOf(RED, YELLOW) -> ORANGE
	setOf(YELLOW, BLUE) -> GREEN
	setOf(BLUE, VIOLET) -> INDIGO
	else -> throw Exception("Dirty color!") // 如果没有匹配到, 最后执行这句
}
