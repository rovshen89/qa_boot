package testNG;

import com.sun.security.jgss.GSSUtil;
import org.testng.annotations.*;

public class TestNGClass extends TestNG_Suite {
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

    @Test
    public void baseNG(){
        System.out.println("Base Test");
    }

    @Test
    public void test1(){
        System.out.println("Test1 method");
    }

    @Test
    public void test2(){
        System.out.println("Test2 method");
    }
}
