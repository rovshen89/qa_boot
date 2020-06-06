package testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestNG_Suite {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("@BeforeSuite method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("@AfterSuite method");
    }
}
