package cc.stevenyin.actioninkotlin.chapter02._02_06;

import cc.stevenyin.actioninkotlin.chapter02._02_05.Person;

public class Test {

	public static void main(String[] args) {
		Person person = new Person("Bob", true);
		System.out.println(person.getName());
		// Bob
		System.out.println(person.isMarried());
		// true
	}
}
