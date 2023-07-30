package Homework10;

import org.junit.Assert;
import org.junit.Test;
import pages.RegisterPage;
import utils.BaseClass;

public class RegisterTest extends BaseClass {

    String linksUrl = "https://demoqa.com/register";

    @Test
    public void registerWithoutCaptcha() {
        RegisterPage registerPage = new RegisterPage(driver);
        driver.get(linksUrl);
        registerPage.setFirstName("Tester");
        registerPage.setLastName("Testov");
        registerPage.setUserName("tester11");
        registerPage.setPassword("Pass123");
        registerPage.clickRegisterButton();
        driver.slowdownBetweenSteps(1);
        String actualErrorMessage = registerPage.getErrorMessageText();
        String expectedErrorMessage = "Please verify reCaptcha to register!";
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
    @Test
    public void successfulRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        driver.get(linksUrl);
        registerPage.setFirstName("Tester");
        registerPage.setLastName("Testov");
        registerPage.setUserName("tester11");
        registerPage.setPassword("Pass_123!");
        registerPage.selectCaptcha();
        registerPage.clickRegisterButton();
    }
}
