package junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JunitiFrame {
    static WebDriver driver;
    static String baseURL;

    @BeforeAll
    public static void setUp(){
        baseURL = "https://letskodeit.teachable.com/p/practice";
        System.setProperty("webdriver.gecko.driver", "D:\\QA_Testing\\Resources\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
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
        Thread.sleep(2000);
        WebElement iframeEle = driver.findElement(By.xpath("//*[contains(@src, 'courses')]"));
//        driver.switchTo().frame("courses-iframe"); //by iframe ID or name
        driver.switchTo().frame(iframeEle); //by Webelement reference

        WebElement findCourse = driver.findElement(By.xpath("//input[@placeholder = 'Find a course']"));
        WebElement submitBtn = driver.findElement(By.id("search-course-button"));
        findCourse.sendKeys("Selenium");
        submitBtn.click();

        driver.switchTo().defaultContent(); // switch back to main page
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        System.out.println("@Test1 - executed test");
    }

}
