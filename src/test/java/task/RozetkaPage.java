package task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RozetkaPage {
    private static final String URL = "https://rozetka.com.ua/";
    private final WebDriver webDriver;
    @FindBy(xpath = "//meta[@name=\"description\"]")
    WebElement textDeliveryThroughoutUkraine;

    public RozetkaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateToUrl() {
        webDriver.navigate().to(URL);
    }

    public boolean textIsPresence(String text) {
        return textDeliveryThroughoutUkraine.getAttribute("content").contains(text);
    }
}
