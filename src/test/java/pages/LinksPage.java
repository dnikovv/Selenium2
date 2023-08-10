package pages;

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
        customWebElement = new WebElementHelper(driver);
    }

    @FindBy(xpath = "//a[@href='http://demoqa.com' and text()='Click Here for Valid Link']")
    public WebElement validLink;
    @FindBy(xpath = "//a[contains(text(),'Click Here for Broken Link')]")
    public WebElement brokenLink;

    public void clickOnValidLink() {
        customWebElement.clickWithWait(validLink, 3);
    }

    public void clickOnBrokenLink() {
        customWebElement.clickWithWait(brokenLink, 3);
    }

    public void scrollToBrokenLink() {
        customWebElement.scrollToElement(brokenLink);
    }

    public void scrollToValidLink() {
        customWebElement.scrollToElement(validLink);
    }
}
