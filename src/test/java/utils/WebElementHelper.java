package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementHelper {
    private WebElement element;
    private WebDriverWait wait;
    private WebDriver driver;

    public WebElementHelper(WebElement element, WebDriver driver) {
        this.element = element;
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void waitForVisibility(int timeoutInSeconds) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(int timeoutInSeconds) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickWithWait(int timeoutInSeconds) {
        waitForVisibility(timeoutInSeconds);
        element.click();
    }

    public void typeText(String text){
        element.clear();
        element.sendKeys(text);
    }

}
