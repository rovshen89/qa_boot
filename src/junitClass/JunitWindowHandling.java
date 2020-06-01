package junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class JunitWindowHandling {
    static WebDriver driver;
    static String baseURL;


    @BeforeAll
    public static void setUp(){
        baseURL = "https://learn.letskodeit.com/p/practice";
        System.setProperty("webdriver.chrome.driver", "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("@BeforeAll - executed once before ALL test methods in this class");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        System.out.println("@AfterAll - executed once before ALL test methods in this class");
    }




    @Test
    public void test1() throws InterruptedException {
        String currentWindow = driver.getWindowHandle();
        System.out.println("Current window handle ID: " + currentWindow);

        driver.findElement(By.id("openwindow")).click();
        Thread.sleep(3000);

        currentWindow = driver.getWindowHandle();
        System.out.println("Current window ID after clicking element: " + currentWindow);

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> iterator = ids.iterator();
        String parentWindow = iterator.next();
        Thread.sleep(3000);
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='Find a course']")).sendKeys("Selenium");
        Thread.sleep(2000);
        driver.findElement(By.id("search-course-button")).click();
        System.out.println("@Test1 - executed test");
    }

}
