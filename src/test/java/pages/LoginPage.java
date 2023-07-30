package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementHelper;

public class LoginPage {
    private WebDriver driver;
    private WebElementHelper customWebElement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    private WebElement userNameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login")
    private WebElement loginButton;
    @FindBy(id = "newUser")
    private WebElement newuserButton;
    @FindBy(id = "name")
    private WebElement loginErrorMessage;


    public void setUserName(String userName) {
        customWebElement = new WebElementHelper(userNameField, driver);
        customWebElement.typeText(userName, 2);
    }

    public void setPassword(String pass) {
        customWebElement = new WebElementHelper(passwordField, driver);
        customWebElement.typeText(pass, 2);
    }

    public void clickLoginButton(){
        customWebElement = new WebElementHelper(loginButton, driver);
        customWebElement.scrollToElement(loginButton);
        customWebElement.clickWithWait(1);
    }

    public void clickNewUserButton(){
        customWebElement = new WebElementHelper(newuserButton,driver);
        customWebElement.clickWithWait(2);
    }
    public String getLoginErrorMessageText() {
        customWebElement = new WebElementHelper(loginErrorMessage, driver);
        customWebElement.scrollToElement(loginErrorMessage);
        return customWebElement.getTextWithWait(1);
    }

}
