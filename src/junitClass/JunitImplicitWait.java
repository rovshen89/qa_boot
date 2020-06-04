package junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class JunitImplicitWait {
    static WebDriver driver;
    static String baseURL;

    @BeforeAll
    public static void setUp(){
        baseURL = "https://www.bankofamerica.com/";
        System.setProperty("webdriver.gecko.driver", "D:\\QA_Testing\\Resources\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("@BeforeAll - executed once before ALL test methods in this class");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        System.out.println("@AfterAll - executed once before ALL test methods in this class");
    }



    @Test
    public void test1(){
        WebElement academy = driver.findElement(By.xpath("//a[contains(@href, 'khanacademy')]"));
        academy.click();
        System.out.println("Element successfully clicked");
        System.out.println("@Test1 - executed test");
    }

}
