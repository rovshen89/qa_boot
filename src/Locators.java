import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bankofamerica.com");
        Thread.sleep(2000);
        driver.findElement(By.id("engagementBannerCloseBtn")).click(); //find element by id
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@aria-controls='navCheckingContent']")).click(); // find element by xpath
        Thread.sleep(2000);
        driver.findElement(By.name("query")).sendKeys("test message"); //find element by name attribute
        Thread.sleep(2000);
        driver.findElement(By.className("search-query")).clear();
        Thread.sleep(2000);
        driver.findElement(By.className("search-query")).sendKeys("a new test message");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Wealth Management")).click();
        Thread.sleep(2000);
        //driver.findElement(By.partialLinkText("Management")).click(); //we can use partial link text also
        driver.quit();

    }
}
