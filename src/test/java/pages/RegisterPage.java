package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebElementHelper;

public class RegisterPage {
    private WebDriver driver;
    private WebElementHelper customWebElement;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        customWebElement = new WebElementHelper(driver);
    }

    @FindBy(id = "firstname")
    private WebElement firstNameField;
    @FindBy(id = "lastname")
    private WebElement lastNameField;
    @FindBy(id = "userName")
    private WebElement userNameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "register")
    private WebElement registerButton;
    @FindBy(id = "name")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@id='rc-anchor-container']//span[@id='recaptcha-anchor']")
    private WebElement captchaElement;
    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    private WebElement captchaIframe;

    public void setFirstName(String firstName) {
        customWebElement.typeText(firstNameField,firstName, 2);
    }

    public void setLastName(String lastName) {
        customWebElement.typeText(lastNameField,lastName, 2);
    }

    public void setUserName(String userName) {
        customWebElement.typeText(userNameField,userName, 2);
    }

    public void setPassword(String password) {
        customWebElement.typeText(passwordField,password, 2);
    }

    public void clickRegisterButton() {
        customWebElement.scrollToElement(registerButton);
        customWebElement.clickWithWait(registerButton,1);
    }

    public String getErrorMessageText() {
        customWebElement.scrollToElement(errorMessage);
        return customWebElement.getTextWithWait(errorMessage,1);
    }

    public void selectCaptcha() {
        driver.switchTo().frame(captchaIframe);
        customWebElement.scrollToElement(captchaElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", captchaElement);
        driver.switchTo().defaultContent();
        customWebElement.waitForInvisibility(captchaElement,2);
    }
}