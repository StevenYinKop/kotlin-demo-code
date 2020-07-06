package com.stevenyin.actioninkotlin.chapter04._object
// 抽象类不能实例化
abstract class Animated {
	// 这个函数是abstract的, 它的子类要实现它 
	abstract fun animate()
	
	// 抽象类中的非抽象函数并不是默认open的, 但是可以标注为open
	open fun stopAnimating() {
		
	}
	fun animateTwice() {}
}