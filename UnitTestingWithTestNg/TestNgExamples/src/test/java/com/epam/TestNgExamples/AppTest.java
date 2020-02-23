package com.epam.TestNgExamples;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
 
 @BeforeGroups("hello")
 void example1() {
	 System.out.println("BEFORE GROUP");
 }
 
 @AfterGroups("hello")
 void example2() {
	 System.out.println("AFTER GROUP");
 }
	
@BeforeSuite
  void method7() {
	System.out.println("BEFORE SUITE");
}
	
@AfterSuite(alwaysRun=true)
   void method8() {
	System.out.println("AFTER SUITE");
}

	
@BeforeClass
 void method5() {
	System.out.println("BEFORE CLASS");
}

@AfterClass
  void method6() {
	System.out.println("AFTER CLASS");
}

 @BeforeTest
 void method1() {
	 System.out.println("BEFORE TEST METHOD");
 }
 
 @BeforeMethod
 void method3() {
	 System.out.println("BEFORE METHOD");
 }
 
 @AfterMethod
 void method4() {
	 System.out.println("AFTER METHOD");
 }
 
 @Test
 void test1() {
	assertEquals(Calculator.add(1,2),3);
	System.out.println("test1");
 }
	
 @Test
 void test2() {
	 assertEquals(Calculator.add(4,5),9);
	 System.out.println("test2");
 }
 
 @AfterTest
 void method() {
	 System.out.println("AFTER TEST METHOD");
 }
 	
 @Test(groups="hello")
 void demo() {
	 System.out.println("Hello group");
 }
 
}
