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
        driver.findElement(By.id("engagementBannerCloseBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@aria-controls='navCheckingContent']")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("query")).sendKeys("test message");
        Thread.sleep(2000);
        driver.quit();

    }
}
