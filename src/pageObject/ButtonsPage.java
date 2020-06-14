package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

public class ButtonsPage {

    //WebElement buttonElement = driver.findElement(By.xpath("//button[text() = 'A button element'])position()=1]"));
    //WebElement submit = driver.findElement(By.xpath("//input[@value = 'A submit button'])position()=1]"));
    //WebElement anchor = driver.findElement(By.xpath("//a[text() = 'An anchor'])position()=1]"));
    //List<WebElement> lisfOfButtons = driver.findElements(By.xpath("//button[text() = 'A button element']"));

    @FindBys(@FindBy(xpath = "//button[text() = 'A button element']"))
    List<WebElement> listOfButtons;

    @FindBy(how = How.XPATH, using = "(//button[text() = 'A button element'])position()=1]")
    WebElement buttonElem;

    @FindBy(how = How.XPATH, using = "(//input[@value = 'A submit button'])position()=1]")
    WebElement submit;

    @FindBy(how = How.LINK_TEXT, using = "An anchor")
    WebElement anchor;

    @FindBy(how = How.LINK_TEXT, using = " view source")
    WebElement viewSource;

    @FindBy(how = How.CLASS_NAME, using = "demo-frame")
    WebElement frame;

    @FindBy(how = How.ID, using = "content")
    WebElement content;


}
