package utils;

import org.openqa.selenium.JavascriptExecutor;
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

    public void waitForInvisibility(int timeoutInSeconds) {
        wait.until(ExpectedConditions.invisibilityOf(element));
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

    public void scrollToElement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        //bring the element into view
    }

    public void waitForValueToBe(String expectedValue, int timeoutInSeconds) {
        wait.until(ExpectedConditions.attributeToBe(element, "value", expectedValue));
        //Wait for the element's input value to match a specific value
    }

    public String getAttributeWithWait(String attributeName, int timeoutInSeconds) {
        waitForVisibility(timeoutInSeconds);
        return element.getAttribute(attributeName);
        //Get the value of a specific attribute of the element after waiting for its visibility
    }

    public String getTextWithWait(int timeoutInSeconds) {
        waitForVisibility(timeoutInSeconds);
        return element.getText();
        //Get the text of the element after waiting for its visibility
    }

}
