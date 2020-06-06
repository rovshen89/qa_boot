package testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.atomic.DoubleAccumulator;

public class TestNG_Suite {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("@BeforeSuite method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("@AfterSuite method");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest method");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("@Aftertest method");
    }


}
