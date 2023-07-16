package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonsPage {
    public WebDriver driver;

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
        yesRadioBtn.click();
    }

    public void clickImpressiveRadioBtn() {
        impressiveRadioBtn.click();
    }

    public String getOutputValue() {
        return outputSpan.getText();
    }

    public WebElement noRadioBtn(){
        return driver.findElement(By.xpath("//input[@id='noRadio' and @disabled]"));
    }
}
