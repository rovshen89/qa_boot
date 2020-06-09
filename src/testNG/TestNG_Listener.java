package testNG;

import listeners.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners({CustomListener1.class, CustomITestListener1.class, CustomSuiteListener1.class})
public class TestNG_Listener {

    WebDriver driver;
    Actions action;
    String baseUrl;

    @DataProvider(name = "linkData")
    public Object[][] getTestData() {
        return new Object[][] {
                {"CLA", "OpenJS Foundation", "openjsf"},
                {"Documentation", "Contributing to jQuery Foundation Documentation", "documentation"},
                {"Bug Triage","Bug Triage", "triage"},
                {"Style Guides", "jQuery’s Style Guides", "style-guide"},
                {"Web Sites", "Contributing to jQuery Foundation Web Sites", "web-sites"},
                {"Code", "Writing Code for jQuery Foundation Projects", "code"}
        };
    }

    @BeforeTest
    public void setUp() {
        baseUrl = "https://jqueryui.com/";
        //create browser driver instance.
        System.setProperty("webdriver.chrome.driver",
                "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "linkData") //Hover on Contribute button and click on each of the menu items
    public void test1(String linkNm, String header, String urlLink) {
        driver.navigate().to(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //hover on a given element Contribute
        WebElement hovContri = driver.findElement(By.xpath("//a[text()='Contribute']"));
        wait.until(ExpectedConditions.visibilityOf(hovContri));
        action.moveToElement(hovContri).perform();

        //click on the given element
        WebElement eachEle = driver.findElement(By.xpath("//a[text()='"+linkNm+"']"));
        wait.until(ExpectedConditions.elementToBeClickable(eachEle)).click();

        String currUrl = driver.getCurrentUrl();
        String actualHead;

        if(linkNm.contains("CLA")) {
            actualHead = driver.findElement(By.xpath("//img[@class='stnd ']")).getAttribute("alt");
        } else {
            actualHead = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        }

        Assert.assertTrue(currUrl.contains(urlLink));
        Assert.assertEquals(actualHead, header);
    }

    @Parameters({"header", "urlLink", "linkNm"})
    @Test(enabled = false) //validate landing url and page element
    public void test2(String header, String urlLink, String linkNm) {
        String currUrl = driver.getCurrentUrl();
        String actualHead;

        if(linkNm.contains("CLA")) {
            actualHead = driver.findElement(By.xpath("//img[@class='stnd ']")).getAttribute("alt");
        } else {
            actualHead = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        }

        Assert.assertTrue(currUrl.contains(urlLink));
        Assert.assertEquals(actualHead, header);
    }

    @AfterMethod
    public void afterTests(ITestResult testResult) {
        if(testResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("Success! Name is="+testResult.getName());
            System.out.println("Success! Host is="+testResult.getHost());
        }
        if(testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!="+testResult.getName());
            System.out.println("Failed! Host is="+testResult.getHost());
        }
    }
}
