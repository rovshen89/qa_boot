package junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JunitAlert {
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
        Thread.sleep(3000);
        driver.quit();
        System.out.println("@AfterAll - executed once before ALL test methods in this class");
    }


    @Test
    public void test1() throws InterruptedException {
        Alert alrt;
        Thread.sleep(5000);

        WebElement alertBtn = driver.findElement(By.id("alertbtn"));
        WebElement confirmBtn = driver.findElement(By.id("confirmbtn"));
        WebElement nameEle = driver.findElement(By.id("name"));


        nameEle.sendKeys("Test message");
        alertBtn.click();
        alrt = driver.switchTo().alert(); //switch to alert window

        System.out.println("alert text is: " + alrt.getText());
        Thread.sleep(3000);
        alrt.accept(); //confirm if you accept alert

        confirmBtn.click();
        Thread.sleep(3000);

        alrt = driver.switchTo().alert();
        Thread.sleep(3000);
        alrt.dismiss();


        System.out.println("@Test1 - executed test");
    }
}
