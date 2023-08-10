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
        customWebElement = new WebElementHelper(driver);
    }

    @FindBy(xpath = "//label[@for = 'yesRadio']")
    WebElement yesRadioBtn;
    @FindBy(xpath = "//label[@for = 'impressiveRadio']")
    WebElement impressiveRadioBtn;
    @FindBy(xpath = "//span[@class = 'text-success']")
    WebElement outputSpan;

    public void clickYesRadioBtn() {
        customWebElement.clickWithWait(yesRadioBtn,2);
    }

    public void clickImpressiveRadioBtn() {
        customWebElement.clickWithWait(impressiveRadioBtn,2);
    }

    public String getOutputValue() {
        return customWebElement.getTextWithWait(outputSpan,2);
    }

    public WebElement noRadioBtn(){
        return driver.findElement(By.xpath("//input[@id='noRadio' and @disabled]"));
    }
}
