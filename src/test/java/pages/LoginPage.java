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
        customWebElement = new WebElementHelper(driver);
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
        customWebElement.typeText(userNameField,userName, 2);
    }

    public void setPassword(String pass) {
        customWebElement.typeText(passwordField,pass, 2);
    }

    public void clickLoginButton(){
        customWebElement.scrollToElement(loginButton);
        customWebElement.clickWithWait(loginButton,1);
    }

    public void clickNewUserButton(){
        customWebElement.clickWithWait(newuserButton,2);
    }
    public String getLoginErrorMessageText() {
        customWebElement.scrollToElement(loginErrorMessage);
        return customWebElement.getTextWithWait(loginErrorMessage,1);
    }

}
