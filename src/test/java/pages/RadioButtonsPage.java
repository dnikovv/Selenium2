package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementHelper;

public class RadioButtonsPage {
    public WebDriver driver;

    private WebElementHelper customWebElement;

    public RadioButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@for = 'yesRadio']")
    WebElement yesRadioBtn;
    @FindBy(xpath = "//label[@for = 'impressiveRadio']")
    WebElement impressiveRadioBtn;
    @FindBy(xpath = "//span[@class = 'text-success']")
    WebElement outputSpan;

    public void clickYesRadioBtn() {
        customWebElement = new WebElementHelper(yesRadioBtn,driver);
        customWebElement.clickWithWait(2);
    }

    public void clickImpressiveRadioBtn() {
        customWebElement = new WebElementHelper(impressiveRadioBtn,driver);
        customWebElement.clickWithWait(2);
    }

    public String getOutputValue() {
        customWebElement = new WebElementHelper(outputSpan,driver);
        return customWebElement.getTextWithWait(2);
    }

    public WebElement noRadioBtn(){
        return driver.findElement(By.xpath("//input[@id='noRadio' and @disabled]"));
    }
}
