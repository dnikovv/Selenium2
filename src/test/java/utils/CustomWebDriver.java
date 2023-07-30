package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomWebDriver implements WebDriver, JavascriptExecutor {

    private org.openqa.selenium.WebDriver webDriver;
    private WebDriverWait webDriverWait;

public void start(Browser browser){
    switch (browser){
        case CHROME:
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            break;
        case FIREFOX:
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
            break;
        case EDGE:
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
            break;
        default:
            throw new IllegalArgumentException(browser.name());
    }
    webDriverWait = new WebDriverWait(webDriver,30);
}

    @Override
    public void get(String url) {
    webDriver.get(url);
    webDriver.manage().window().maximize();
    //maybe implement some implicit wait here and also delete cookies
    }

    @Override
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return webDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        List<WebElement> nativeWebElements = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        List<WebElement> elements = new ArrayList<>();
        for (WebElement nativeWebElement : nativeWebElements) {
            elements.add(nativeWebElement);
        }
        return elements;
    }

    @Override
    public WebElement findElement(By by) {
        WebElement nativeWebElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return nativeWebElement;
    }

    @Override
    public String getPageSource() {
        return webDriver.getPageSource();
    }

    @Override
    public void close() {
    webDriver.close();
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return webDriver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return webDriver.navigate();
    }

    @Override
    public Options manage() {
        return webDriver.manage();
    }

    public void slowdownBetweenSteps(int delayInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, delayInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//dummyElement")));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) webDriver).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return ((JavascriptExecutor) webDriver).executeAsyncScript(script, args);
    }

    public enum Browser {
        CHROME,
        FIREFOX,
        EDGE,
    }
}
