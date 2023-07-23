package Homework10;

import org.junit.Assert;
import org.junit.Test;
import pages.RadioButtonsPage;
import utils.BaseClass;

public class RadioButtonTest extends BaseClass {

    String radioBtnUrl = "https://demoqa.com/radio-button";

    @Test
    public void checkTheYesRadioBtn() {
        RadioButtonsPage radioButton = new RadioButtonsPage(driver);
        driver.get(radioBtnUrl);
        radioButton.clickYesRadioBtn();
        driver.slowdownBetweenSteps(2);
        String actualResult = radioButton.getOutputValue();
        String expectedResult = "Yes";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkTheImpressiveRadioBtn() {
        RadioButtonsPage radioButton = new RadioButtonsPage(driver);
        driver.get(radioBtnUrl);
        radioButton.clickImpressiveRadioBtn();
        String actualResult = radioButton.getOutputValue();
        String expectedResult = "Impressive";
        driver.slowdownBetweenSteps(2);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyNoRadioBtnIsNotClickable() {
        RadioButtonsPage radioButton = new RadioButtonsPage(driver);
        driver.get(radioBtnUrl);
        driver.slowdownBetweenSteps(2);
        Assert.assertFalse("The checkbox is disabled and not clickable", radioButton.noRadioBtn().isEnabled());
    }
}
