package Homework11;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utils.BaseClass;

public class LoginTest extends BaseClass {
    String linksUrl = "https://demoqa.com/login";

    @Test
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(linksUrl);
        loginPage.setUserName("Testerr");
        loginPage.setPassword("Pass123_!");
        loginPage.clickLoginButton();
        driver.slowdownBetweenSteps(1);
        String actualErrorMessage = loginPage.getLoginErrorMessageText();
        String expectedErrorMessage = "Invalid username or password!";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(linksUrl);
        loginPage.setUserName("Tester990");
        loginPage.setPassword("Pass123_!");
        loginPage.clickLoginButton();
        driver.slowdownBetweenSteps(2);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("profile"));
    }

    @Test
    public void verifyRegisterButton(){
        LoginPage loginPage = new LoginPage(driver);
        driver.get(linksUrl);
        loginPage.clickNewUserButton();
        driver.slowdownBetweenSteps(2);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("register"));
    }
}
