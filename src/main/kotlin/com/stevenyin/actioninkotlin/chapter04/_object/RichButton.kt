package com.stevenyin.actioninkotlin.chapter04._object

open class RichButton: IClickable{ // 这个类是open的, 其他类可以继承这个类
	fun disable() {} //这个方法是final的, 子类不能重写它
	open fun animate() {} // 这个类是open的, 可以在子类中重写它
	final override fun click() { // 这个函数重写了一个open函数, 所以它也是open的, 如果不想让这个类被子类重写, 就在前面显示加上final
		
	}
}