package cssLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
* Wild card enables user to form css selector by providing partial value of a chosen attribute
* Syntax: tag[attribute<WildChar>='partial value]
* Allowed wild char set
* ^ - Starting character set
* $ - Ending character set
* * - Containing character set*/
public class WIldCardChars {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\QA_Testing\\Resources\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bankofamerica.com");

        //navCheckingContent - ways to locate using wild card
        driver.findElement(By.cssSelector("a[aria-controls^='navCh']")).click(); //starting char set
        driver.findElement(By.cssSelector("a[aria-controls$='ckingContent']")).click(); //ending char set
        driver.findElement(By.cssSelector("a[aria-controls*='Checking']")).click(); //containing char set

        driver.findElement(By.cssSelector("a[aria-controls^='navCh']>span[class = 'title']")).click(); //navigate to child element
        driver.findElement(By.cssSelector("a[aria-controls^='navCh']>span.title")).click(); //navigate to child element dot class syntax


    }
}
