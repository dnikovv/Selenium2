package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementHelper;

public class LinksPage {
    private WebDriver driver;
    private WebElementHelper customWebElement;

    public LinksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='http://demoqa.com' and text()='Click Here for Valid Link']")
    private WebElement validLink;
    @FindBy(xpath = "//a[contains(text(),'Click Here for Broken Link')]")
    private WebElement brokenLink;

    public void clickOnValidLink() {
        customWebElement = new WebElementHelper(validLink,driver);
        customWebElement.clickWithWait(3);
    }

    public void clickOnBrokenLink() {
        customWebElement = new WebElementHelper(brokenLink, driver);
        customWebElement.clickWithWait(3);
    }

    public WebElement locateBrokenLinks() {
        return driver.findElement(By.xpath("//a[contains(text(),'Click Here for Broken Link')]"));
    }
}
