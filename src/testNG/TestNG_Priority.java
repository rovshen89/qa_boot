package testNG;

import org.testng.annotations.*;

public class TestNG_Priority extends TestNG_Suite {
    @BeforeClass
    public void setUp(){
        System.out.println("@BeforeClass method");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("@AfterClass method");
    }

    @BeforeMethod
    public void init(){
        System.out.println("@BeforeMethod method");
    }

    @AfterMethod
    public void quit(){
        System.out.println("@AfterMethod method");
    }

    @Test(priority = 0)
    public void baseNG(){
        System.out.println("Base Test");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("Test1 method");
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("Test2 method");
    }
}
