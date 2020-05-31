package junitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junitClass.JunitSelenium.baseUrl;

public class JunitSE {
    static WebDriver driver;
    static String baseURL;
    static JavascriptExecutor jse;

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

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(3000);
        WebElement checking = driver.findElement(By.xpath("//a[@aria-controls = 'navCheckingContent']"));
        jse.executeScript("arguments[0].click();", checking);
        System.out.println("Test1 execution");
    }


}
