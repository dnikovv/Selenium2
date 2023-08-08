package Homework10;

import org.junit.Assert;
import org.junit.Test;
import pages.LinksPage;
import utils.BaseClass;
import utils.HttpUtils;

import java.io.IOException;

public class LinksTest extends BaseClass {
    String linksUrl = "https://demoqa.com/broken/";

    @Test
    public void verifyValidLink() {
        LinksPage linksPage = new LinksPage(driver);
        driver.get(linksUrl);
        linksPage.scrollToValidLink();
        linksPage.clickOnValidLink();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://demoqa.com/"));
    }

    @Test
    public void checkBrokenLink() throws IOException {
        LinksPage linksPage = new LinksPage(driver);
        driver.get(linksUrl);
        linksPage.scrollToBrokenLink();
        String brokenLinkUrl = linksPage.brokenLink.getAttribute("href");
        linksPage.clickOnBrokenLink();
        int statusCode = HttpUtils.getStatusCode(brokenLinkUrl);
        Assert.assertEquals("The status code is not 500.", 500, statusCode);
    }
}