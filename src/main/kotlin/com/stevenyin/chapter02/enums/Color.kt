package com.stevenyin.enums

// Enum 带有属性类型的枚举类型
enum class Color(
		val r : Int, val g: Int, val b: Int
) {
	RED(255, 0, 0),
	ORANGE(255, 165, 0),
	YELLOW(255, 255, 0),
	GREEN(0, 255, 0),
	BLUE(0, 0, 255),
	INDIGO(75, 0, 130),
	VIOLET(238, 130, 238);

	fun rgb() = (r * 256 + g) * 256 + b
	// 用when来处理枚举类型
	fun getMnemonic(color: Color) = when (color) {
		Color.RED -> "Rechard"
		Color.ORANGE -> "Of"
		Color.YELLOW -> "York"
		Color.GREEN -> "Gave"
		Color.BLUE -> "Battle"
		Color.INDIGO -> "In"
		Color.VIOLET -> "Vain"
	}
	// 在when的分支合并多个选项
	fun getWarmth(color: Color) = when (color) {
		RED, ORANGE, YELLOW -> "warm"
		GREEN -> "neutral"
		BLUE, INDIGO, VIOLET -> "color"
	}
	// 在when分支中使用不同对象
	fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
		setOf(RED, YELLOW) -> ORANGE
		setOf(YELLOW, BLUE) -> GREEN
		setOf(BLUE, VIOLET) -> INDIGO
		else -> throw Exception("Dirty color!")
	}
	// 使用不带参数的when
	fun mixOptimized(c1: Color, c2: Color) =
		when {
			//  没有给when传参数, 那么分支上就是Boolean表达式
			(c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
			(c1 == BLUE && c2 == YELLOW) || (c1 == YELLOW && c2 == BLUE) -> GREEN
			(c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
			else -> throw Exception("Dirty color!")
		}
}