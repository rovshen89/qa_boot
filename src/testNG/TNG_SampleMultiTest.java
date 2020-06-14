package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TNG_SampleMultiTest {
    String baseURL;
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        baseURL = "https://jqueryui.com";
        System.setProperty("webdriver.chrome.driver", "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.findElement(By.xpath("//a[text() = 'Button']")).click();
        driver.switchTo().frame(0);

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void buttonsClick(){
        WebElement buttonElement = driver.findElement(By.xpath("//button[text() = 'A button element'])position()=1]"));
        buttonElement.click();
    }

    @Test
    public void submitCLick(){
        WebElement submit = driver.findElement(By.xpath("//input[@value = 'A submit button'])position()=1]"));
        submit.click();
    }

    @Test
    public void anchorClick(){
        WebElement anchor = driver.findElement(By.xpath("//a[text() = 'An anchor'])position()=1]"));
        anchor.click();
    }



}
