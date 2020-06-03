package junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
/*
* Create Actions action object. Then perform actions defined by webelements. */
public class JunitActions {
    static WebDriver driver;
    static String baseURL;
    static Actions action;

    @BeforeAll
    public static void setUp(){
        baseURL = "https://jqueryui.com/";
        System.setProperty("webdriver.gecko.driver", "D:\\QA_Testing\\Resources\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("@BeforeAll - executed once before ALL test methods in this class");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
        System.out.println("@AfterAll - executed once before ALL test methods in this class");
    }



    @Test
    public void test1() throws InterruptedException {
        WebElement hovSupport = driver.findElement(By.xpath("//section//a[text()='Support']"));
        WebElement forumClick = driver.findElement(By.xpath("//a[text()='Forums']"));

        action.moveToElement(hovSupport).perform(); //to hover on a given Web element
        Thread.sleep(3000);
        action.moveToElement(forumClick).click().perform(); //to click on a given Web element
        Thread.sleep(3000);

        String currURL = driver.getCurrentUrl();
        Assertions.assertEquals("https://forum.jquery.com/", currURL, "URL mismatch. Current URL is: " + currURL);
        System.out.println("Current URL is: " + currURL);
        System.out.println("@Test1 - executed test");
    }

}
