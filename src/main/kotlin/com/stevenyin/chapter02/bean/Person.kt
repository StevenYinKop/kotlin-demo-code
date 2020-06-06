package com.stevenyin.bean

//public class Person {
//	private final String name;
//	private final int age;
//  private Boolean isMarried;
//	@getter
//  final 成员变量, 没有setter方法
//  public void setIsMarried(Boolean isMarried) {
//      this.isMarried = isMarried;
//  }
//}

class Person (val name: String, val age: Int, var isMarried: Boolean)

fun main() {
	val person = Person("Jack", 20, true)
	println(person)
}