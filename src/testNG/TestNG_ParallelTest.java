package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_ParallelTest extends TestNG_Suite {
    static WebDriver driver;
    static String baseURL;
    static Actions action;

    @Parameters({"browser", "platform"})
    @BeforeClass
    public void setUp(String browser, String platform){
        System.out.println("Browser name: " + browser);
        System.out.println("Platform name: " + platform);
        setBrowser(browser);
        baseURL = "https://jqueryui.com/";
//        System.setProperty("webdriver.gecko.driver", "D:\\QA_Testing\\Resources\\geckodriver\\geckodriver.exe");
//        driver = new FirefoxDriver();
        action = new Actions(driver);
//        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("@BeforeClass method");
    }

    private void setBrowser(String browser){
        switch (browser.toLowerCase()){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "D:\\QA_Testing\\Resources\\geckodriver\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        System.out.println("@AfterClass method");
    }



    @Test
    public void baseNG() throws InterruptedException {
        Thread.sleep(3000);
        WebElement hovSupport = driver.findElement(By.xpath("//section//a[text()='Support']"));
        WebElement forumClick = driver.findElement(By.xpath("//a[text()='Forums']"));

        action.moveToElement(hovSupport).perform(); //to hover on a given Web element
        Thread.sleep(3000);
        action.moveToElement(forumClick).click().perform(); //to click on a given Web element
        Thread.sleep(3000);

        String currURL = driver.getCurrentUrl(); //check expected vs current URL
        Assert.assertEquals("https://forum.jquery.com/", currURL, "URL mismatch. Current URL is: " + currURL);
        System.out.println("Current URL is: " + currURL);
        System.out.println("@Test1 - executed test");
        System.out.println("Base Test");
    }

    @Test(dependsOnMethods = {"baseNG"})
    public void test1() throws InterruptedException {
        Thread.sleep(3000);
        WebElement getStarted = driver.findElement(By.xpath("//a[text() = 'Getting Started']"));
        getStarted.click();
        System.out.println("Test1 method");
        Assert.assertTrue(driver.getCurrentUrl().contains("getting-started"));
    }

    @Test(dependsOnMethods = {"baseNG", "test1"})
    public void test2(){

        System.out.println("Test2 method");
    }
}
