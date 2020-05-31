package cssLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",  "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //XPATH - syntaxes
        driver.findElement(By.xpath("//tag[@attribute = 'value']")).click(); //relative xpath
        driver.findElement(By.xpath("//tag[text() = 'text of the element']")).click(); //xpath using text() keyword
        driver.findElement(By.xpath("//tag[contains(@attribute, 'partial value')]")).click(); //xpath using contains() keyword
        driver.findElement(By.xpath("//tag[contains(text(), 'partial text value')]")).click(); //xpath using contains and text() keyword
        driver.findElement(By.xpath("//tag[contains(text(), 'partial text value') and @attribute = 'value']")).click(); //xpath using contains and 'and'() keyword
        driver.findElement(By.xpath("//tag[starts-with(@attribute, 'starting char set of value')")).click(); //xpath using starts-with keyword
        
    }

}
