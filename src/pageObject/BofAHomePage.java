package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class BofAHomePage {

    /*driver1.findElement(By.xpath
            ("//span[text()='Get started' " +
            "or text()='Click to get started' " +
            "or text()='Open' " +
            "or text()='See options' " +
            "or text()='Click to see options' " +
            "or text()='Learn more' " +
            "or text()='Continue' " +
            "or text()='Click to open']")).click();*/

    @FindAll({@FindBy(xpath = "//span[text()='Get started'"),
            @FindBy(xpath = "//span[text()='Click to get started'"),
            @FindBy(xpath = "//span[text()='Open'"),
            @FindBy(xpath = "//span[text()='See options'"),
            @FindBy(xpath = "//span[text()='Click to see options'"),
            @FindBy(xpath = "//span[text()='Learn more'"),
            @FindBy(xpath = "//span[text()='Continue'"),
            @FindBy(xpath = "//span[text()='Click to open'")
    })
    WebElement homeclick1;


}
