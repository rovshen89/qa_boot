import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverIE {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.tatilsepeti.com");
        driver.switchTo().alert().accept();
        driver.findElement(By.id("bolge")).sendKeys("test");
//        driver.quit();
    }
}
