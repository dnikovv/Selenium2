package Homework10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.PracticeFormPage;
import utils.BaseClass;

import static pages.PracticeFormPage.isEmailFieldHighlightedInRed;

public class PracticeFormTest extends BaseClass {

    String url = "https://demoqa.com/automation-practice-form";

    @Test
    public void fillFormWithWrongEmailFormat() {
        PracticeFormPage formPage = new PracticeFormPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(url);
        formPage.setFirstName("Tester");
        formPage.setLastName("Testov");
        formPage.setMailAddress("test1212");
        boolean isHighlightedRed = isEmailFieldHighlightedInRed(formPage.phoneField());
        formPage.clickGenderBtn();
        formPage.enterUserPhone("929192");
        js.executeScript("window.scrollBy(0, 1500)");
        formPage.enterSubject("blablabla");
        formPage.clickSportCheckBox();
        formPage.uploadFile("D:/images/bohorainbow.jpg");
        formPage.setCurrentAddress("Sofia, Lagera");
        formPage.clickSubmitBtn();
        driver.slowdownBetweenSteps(2);
        Assert.assertTrue("The input field is not highlighted in red.", isHighlightedRed);
        //cannot get the color of the border..
    }

    @Test
    public void fillForm() {
        PracticeFormPage formPage = new PracticeFormPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(url);
        formPage.setFirstName("Tester");
        formPage.setLastName("Testov");
        formPage.setMailAddress("test@2231.com");
        formPage.clickGenderBtn();
        formPage.enterUserPhone("929192");
        js.executeScript("window.scrollBy(0, 1500)");
        formPage.enterSubject("blablabla");
        formPage.clickSportCheckBox();
        formPage.uploadFile("D:/images/bohorainbow.jpg");
        formPage.setCurrentAddress("Sofia, Lagera");
        formPage.clickSubmitBtn();
    }
}
