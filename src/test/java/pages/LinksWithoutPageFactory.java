package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CustomWebDriver;
import utils.WebElementHelper;

public class LinksWithoutPageFactory {

    public WebDriver driver;
    private WebElementHelper customWebElement;

    final By VALID_LINK = By.xpath("//a[@href='http://demoqa.com' and text()='Click Here for Valid Link']");
    final By BROKEN_LINK = By.xpath("//a[contains(text(),'Click Here for Broken Link')]");

    public LinksWithoutPageFactory(CustomWebDriver driver) {
        this.driver = driver;
        customWebElement = new WebElementHelper(driver);
    }

    public void clickOnValidLink() {
        WebElement validLink = driver.findElement(VALID_LINK);
        customWebElement.clickWithWait(validLink,3);
    }

    public void clickOnBrokenLink() {
        WebElement brokenLink = driver.findElement(BROKEN_LINK);
        customWebElement.clickWithWait(brokenLink,3);
    }

    public void scrollToValidLink(){
        WebElement validLink = driver.findElement(VALID_LINK);
        customWebElement.scrollToElement(validLink);
    }

    public void scrollToBrokenLink(){
        WebElement brokenLink = driver.findElement(VALID_LINK);
        customWebElement.scrollToElement(brokenLink);
    }

    public WebElement locateBrokenLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'Click Here for Broken Link')]"));
    }

}
