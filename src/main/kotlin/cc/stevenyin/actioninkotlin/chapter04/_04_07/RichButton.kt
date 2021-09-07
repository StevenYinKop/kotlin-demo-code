package cc.stevenyin.actioninkotlin.chapter04._04_07

import cc.stevenyin.actioninkotlin.chapter04._04_03.Clickable

class RichButton : Clickable{
	// 如果想要禁止子类重写, 这里要显示写上final, 因为他来自override, 也就是说这个方法它是open的
	final override fun click() {
	
	}
}