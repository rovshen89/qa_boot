package junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static junitClass.JunitSelenium.baseUrl;



@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class JunitJSE {
    static WebDriver driver;
    static String baseURL;
    static JavascriptExecutor jse;
    private Object WebElement;

    @BeforeAll
    public static void setup(){
        baseURL = "https://www.bankofamerica.com/";
        System.setProperty("webdriver.gecko.driver", "D:\\QA_Testing\\Resources\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get(baseURL);

        jse = (JavascriptExecutor) driver;

        //window.location = '<url>'
        jse.executeScript("window.location = arguments[0]",  baseURL);

        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        System.out.println("Quit all active windows");
    }

    @Test//replacement for driver click
    public void click() throws InterruptedException {
        Thread.sleep(3000);
        WebElement checking = driver.findElement(By.xpath("//a[@aria-controls = 'navCheckingContent']"));
        jse.executeScript("arguments[0].click();", checking);
        System.out.println("Test1 execution");
    }

    @Test//replacement for driver sendKeys
    public void sendKeys() throws InterruptedException {
        Thread.sleep(3000);
        WebElement onlineID = driver.findElement(By.xpath("//input[@aria-labelledby='labelForonlineId1']"));
//        Actions act = driver.findElement(By.xpath("//input[@aria-labelledby='labelForonlineId1']"))
        jse.executeScript("arguments[0].value='tester1';", onlineID);
        Thread.sleep(5000);
        jse.executeScript("arguments[0].value=arguments[1]", onlineID, " tester2");
        System.out.println("Test1 execution");
    }

    @Test
    public void scroll() throws InterruptedException {
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(3000);
        System.out.println("Test scroll executed");
    }

    @Test
    public void scrollView() throws InterruptedException {
        Thread.sleep(2000);
        WebElement agree =  (WebElement) jse.executeScript("return document.getElementById(arguments[0])", "labelForonlineId1");
        jse.executeScript("arguments[0].scrollIntoView(true)", agree);
    }

    @Test
    public void windowSize() throws InterruptedException {
        Thread.sleep(2000);
        long height = (Long) jse.executeScript("return window.innerHeight");
        long width = (Long) jse.executeScript("return window.innerWidth");
        System.out.println("Window dimensions are: " + height + "x" + width);
    }

}
