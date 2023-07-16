package utils;

import org.junit.After;
import org.junit.Before;

public class BaseClass {
    public CustomWebDriver driver;

    @Before
    public void testInit(){
    driver = new CustomWebDriver();
    driver.start(CustomWebDriver.Browser.CHROME);
    }

    @After
    public void tearDown(){
    driver.quit();
    }

}
