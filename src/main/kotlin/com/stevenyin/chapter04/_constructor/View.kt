package com.stevenyin.chapter04._constructor

open class View {
	constructor(ctx: String) {
		println("ctx=$ctx")
	}

	constructor(ctx: String, attr: String) {
		println("ctx=$ctx, attr=$attr")
	}
}

class MyButton : View {
	constructor(ctx: String) : super(ctx) {}
	constructor(ctx: String, attr: String) : super(ctx, attr) {}
}

class MyButton2 : View {
	constructor(ctx: String) : this(ctx, "default") {}
	constructor(ctx: String, attr: String) : super(ctx, attr) {}
}
