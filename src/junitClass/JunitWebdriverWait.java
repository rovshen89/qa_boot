package junitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class JunitWebdriverWait {
    static WebDriver driver;
    static String baseURL;

    @BeforeAll
    public static void setUp(){
        baseURL = "https://www.bankofamerica.com/";
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
    public void WebdriverWaitm(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement academy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'khanacademy')]")));
        academy.click();
        System.out.println("Element successfully clicked");
        System.out.println("@Test1 - executed test");
    }

    @Test
    public void FluentWait(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) //how much wait time
                .pollingEvery(Duration.ofSeconds(2)) //how much frequency of each wait
                .ignoring(NoSuchElementException.class); //ignore exception classes
        WebElement academy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'khanacademy')]")));
        academy.click();
        System.out.println("Element successfully clicked");
        System.out.println("@Test1 - executed test");
    }

}
