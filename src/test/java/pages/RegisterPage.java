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
        customWebElement = new WebElementHelper(firstNameField, driver);
        customWebElement.typeText(firstName, 2);
    }

    public void setLastName(String lastName) {
        customWebElement = new WebElementHelper(lastNameField, driver);
        customWebElement.typeText(lastName, 2);
    }

    public void setUserName(String userName) {
        customWebElement = new WebElementHelper(userNameField, driver);
        customWebElement.typeText(userName, 2);
    }

    public void setPassword(String password) {
        customWebElement = new WebElementHelper(passwordField, driver);
        customWebElement.typeText(password, 2);
    }

    public void clickRegisterButton() {
        customWebElement = new WebElementHelper(registerButton, driver);
        customWebElement.scrollToElement(registerButton);
        customWebElement.clickWithWait(1);
    }

    public String getErrorMessageText() {
        customWebElement = new WebElementHelper(errorMessage, driver);
        customWebElement.scrollToElement(errorMessage);
        return customWebElement.getTextWithWait(1);
    }

    public void selectCaptcha() {
        customWebElement = new WebElementHelper(captchaElement, driver);
        driver.switchTo().frame(captchaIframe);
        customWebElement.scrollToElement(captchaElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", captchaElement);
        driver.switchTo().defaultContent();
        customWebElement.waitForInvisibility(captchaElement);
    }
}