package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage {

    //WebElement buttonElement = driver.findElement(By.xpath("//button[text() = 'A button element'])position()=1]"));
    //WebElement submit = driver.findElement(By.xpath("//input[@value = 'A submit button'])position()=1]"));
    //WebElement anchor = driver.findElement(By.xpath("//a[text() = 'An anchor'])position()=1]"));

    @FindBy
    WebElement buttonElem;
    WebElement submit;
    WebElement anchor;


}
