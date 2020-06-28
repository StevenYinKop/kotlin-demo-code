package com.stevenyin.chapter02._02_06;

import com.stevenyin.chapter02._02_05.Person;

public class Test {

	public static void main(String[] args) {
		Person person = new Person("Bob", true);
		System.out.println(person.getName());
		// Bob
		System.out.println(person.isMarried());
		// true
	}
}
