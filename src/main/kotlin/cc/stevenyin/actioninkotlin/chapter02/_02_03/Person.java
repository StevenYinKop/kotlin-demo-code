package cc.stevenyin.actioninkotlin.chapter02._02_03;

public class Person {
	private final String name;
	public Person(String name) {
		this.name = name;
	}
//  final 成员变量, 没有setter方法
	public String getName() {
		return name;
	}
}
