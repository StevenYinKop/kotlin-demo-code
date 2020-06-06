package com.stevenyin.chapter04._serializable

import java.io.Serializable

interface State: Serializable

interface View {
	fun getCurrentState(): State
	fun restoreState(state: State)
}