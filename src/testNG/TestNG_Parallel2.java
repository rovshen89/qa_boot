package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Parallel2 {
    WebDriver driver;
    String baseURL;
    Actions action;


    @BeforeClass
    public void setUp(){
        baseURL = "https://jqueryui.com";
        System.setProperty("webdriver.chrome.driver",
                "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("Navigated to specified URL");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        System.out.println("Quit all open browsers");
    }

    @Test
    public void test1(){
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //Hower to defined element
        WebElement hovContrib = driver.findElement(By.xpath("//a[text() = 'Contribute']"));
        wait.until(ExpectedConditions.visibilityOf(hovContrib));
        action.moveToElement(hovContrib).perform();

        //click defined element
        WebElement eachEle = driver.findElement(By.xpath("//a[text() = 'CLA']"));
        wait.until(ExpectedConditions.visibilityOf(eachEle)).click();
    }

    @Test
    public void test2(){
        String currURL = driver.getCurrentUrl();
        Assert.assertTrue(currURL.contains("openjsf"));

        String openJSalt = driver.findElement(By.xpath("//img[@class = 'stnd ']")).getAttribute("alt");
        Assert.assertEquals(openJSalt, "OpenJS Foundation");

    }

}
