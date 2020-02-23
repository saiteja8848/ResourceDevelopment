package com.epam.TestNgExamples;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

class Demo {
	String s;

	Demo(String s) {
		this.s = s;
	}

	@Test
	void test() {
		System.out.println("Demo");
	}

}

public class FactoryDemo {

	@Test
	void test() {
		System.out.println("hello");
	}

	@Factory
	public Object[] factorydemo() {
		return new Object[] { new FactoryDemo(), new FactoryDemo() };
	}

}