package cssLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://learn.letskodeit.com/p/practice");
        String price = driver.findElement(By.xpath("//td[text() = 'JavaScript Programming Language']/following-sibling::td")).getText();
        System.out.println(price);
        driver.quit();
    }
}
