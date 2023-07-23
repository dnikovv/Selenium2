package Homework10;

import org.junit.Assert;
import org.junit.Test;
import pages.LinksWithoutPageFactory;
import utils.BaseClass;
import utils.HttpUtils;

import java.io.IOException;

public class LinksWithoutPageFactoryTest extends BaseClass {

    String linksUrl = "https://demoqa.com/broken/";

    @Test
    public void verifyValidLink() {
        LinksWithoutPageFactory testPage = new LinksWithoutPageFactory(driver);
        driver.get(linksUrl);
        testPage.scrollToValidLink();
        driver.slowdownBetweenSteps(1);
        testPage.clickOnValidLink();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://demoqa.com/"));
    }

    @Test
    public void checkBrokenLink() throws IOException {
        LinksWithoutPageFactory testPage = new LinksWithoutPageFactory(driver);
        driver.get(linksUrl);
        testPage.scrollToBrokenLink();
        String brokenLinkUrl = testPage.locateBrokenLink().getAttribute("href");
        testPage.clickOnBrokenLink();
        int statusCode = HttpUtils.getStatusCode(brokenLinkUrl);
        Assert.assertEquals("The status code is not 500.", 500, statusCode);
    }


}
