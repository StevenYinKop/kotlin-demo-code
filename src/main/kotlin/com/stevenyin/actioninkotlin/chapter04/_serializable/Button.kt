package com.stevenyin.actioninkotlin.chapter04._serializable

class Button: View {
	override fun getCurrentState() = ButtonState()

	override fun restoreState(state: State) {
		TODO()
	}
	class ButtonState: State {
		
	}
}