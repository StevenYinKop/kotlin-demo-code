package com.stevenyin.actioninkotlin.chapter04._04_11

import com.stevenyin.actioninkotlin.chapter04._04_09.View
import com.stevenyin.actioninkotlin.chapter04._04_09.State
class Button: View {
	override fun getCurrentState() = ButtonState()
	override fun restoreState(state: State) {
		TODO()
	}
	class ButtonState: State {
	}
	// 对于Kotlin这种语法, 和4.10中添加static修饰后的语法意义是一样的(这里还相当于多了个final),
	// 要把它变成一个内部类来持有外部类的引用的话, 需要加上一个inner修饰符, 这样的话, 和4.10中不写static是一样的了
}