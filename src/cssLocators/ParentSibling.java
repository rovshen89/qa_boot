package cssLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentSibling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",  "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bankofamerica.com");

        String preceedingSibling = driver.findElement(By.xpath("//span[starts-with(text(), 'Better Money Habits')]//parent::a//parent::li//preceding-sibling::li[1]")).getText();
        // use index numbers for multiple parent. anything following after main node considered as parent
        System.out.println(preceedingSibling);

        String followingSibling  = driver.findElement(By.xpath("//span[starts-with(text(), 'Better Money Habits')]//parent::a//parent::li//following-sibling::li")).getText();//hidden element
        System.out.println(followingSibling);

        driver.quit();

    }
}
