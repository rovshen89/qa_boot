package cssLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssByClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",  "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bankofamerica.com");
        Thread.sleep(2000);
        //syntax ".classValue" - use dot if there is unique class attribute value
        driver.findElement(By.cssSelector(".search-query")).sendKeys("test message");
        Thread.sleep(2000);
        driver.quit();
    }
}
