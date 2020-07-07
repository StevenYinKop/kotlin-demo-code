package com.stevenyin.actioninkotlin.chapter04._04_10;

import com.stevenyin.actioninkotlin.chapter04._04_09.State;
import com.stevenyin.actioninkotlin.chapter04._04_09.View;

public class Button implements View{

	public State getCurrentState() {
		return new ButtonState();
	}

	public void restoreState(State arg0) {
		
	}
	
	public class ButtonState implements State{}
	// ButtonState是Button的内部类, ButtonState隐式地存储了它的外部Button类的引用,
	// 当我们想要对ButtonState进行序列化的时候, 会出现java.io.NotSerializableException: Button
	// 由于Button是不可以序列化的, 所以破坏了ButtonState的序列化
	// 为了修复这个问题, 需要把ButtonState类声明成static的, 因为将一个内部类声明成static的, 会从这个类中删除掉他的Outer引用
}
