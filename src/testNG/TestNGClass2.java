package testNG;

import org.testng.annotations.*;

public class TestNGClass2 {
    @BeforeClass
    public void setUp(){
        System.out.println("Class2 - @BeforeClass method");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Class2 - @AfterClass method");
    }

    @BeforeMethod
    public void init(){
        System.out.println("Class2 - @BeforeMethod method");
    }

    @AfterMethod
    public void quit(){
        System.out.println("Class2 - @AfterMethod method");
    }

    @Test
    public void baseNG(){
        System.out.println("Class2 - Base Test");
    }

    @Test
    public void test1(){
        System.out.println("Class2 - Test1 method");
    }

    @Test
    public void test2(){
        System.out.println("Class2 - Test2 method");
    }
}
