package com.demo.tests;
import org.testng.annotations.*;

public class TestNGAnnotationsDemo {
	@BeforeSuite
    public void beforeSuite() {
        System.out.println("1 - Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("2 - Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("3 - Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("4 - Before Method");
    }

    @Test
    public void testCase1() {
        System.out.println("5 - Executing Test Case 1");
    }

    @Test
    public void testCase2() {
        System.out.println("6 - Executing Test Case 2");
    }

  

    @AfterClass
    public void afterClass() {
        System.out.println("8 - After Class");
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("7 - After Method");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("9 - After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("10 - After Suite");
    }

}
