package cc.stevenyin.actioninkotlin.chapter02._02_16

import cc.stevenyin.actioninkotlin.chapter02._02_11.Color
import cc.stevenyin.actioninkotlin.chapter02._02_11.Color.*

class MixOptimized
fun mixOptimized(c1: Color, c2: Color) = 
	when { // 使用不带参数的when
		//  没有给when传参数, 那么分支上就是Boolean表达式
		(c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
		(c1 == BLUE && c2 == YELLOW) || (c1 == YELLOW && c2 == BLUE) -> GREEN
		(c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
		else -> throw Exception("Dirty color!")
	}

