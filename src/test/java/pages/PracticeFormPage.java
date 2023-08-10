package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CustomWebDriver;
import utils.WebElementHelper;

public class PracticeFormPage {
    WebDriver driver;
    private WebDriverWait wait;

    private WebElementHelper customWebElement;
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(css = "label[for='gender-radio-1'].custom-control-label")
    WebElement genderRadioBtn;
    @FindBy(className = "subjects-auto-complete__value-container")
    WebElement subjectField;
    @FindBy(id = "userNumber")
    WebElement userPhone;
    @FindBy(css = "label[for='hobbies-checkbox-1'].custom-control-label")
    WebElement sportCheckBox;
    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "uploadPicture")
    WebElement uploadFileBtn;

    @FindBy(id = "submit")
    WebElement submitBtn;

    public PracticeFormPage(CustomWebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3);
        PageFactory.initElements(driver, this);
        customWebElement = new WebElementHelper(driver);
    }

    public void setFirstName(String fName) {
        customWebElement.typeText(firstName,fName,2);
    }

    public void setLastName(String lName) {
        customWebElement.typeText(lastName,lName,2);
    }

    public void setMailAddress(String mail) {
        customWebElement.typeText(userEmail,mail,2);
    }

    public void clickGenderBtn() {
        customWebElement.clickWithWait(genderRadioBtn,3);
    }

    public void enterUserPhone(String phone) {
        customWebElement.typeText(userPhone,phone,2);
    }

    public void enterSubject(String subject) {
        customWebElement.clickWithWait(subjectField,3);
    }

    public void clickSportCheckBox() {
        customWebElement.clickWithWait(sportCheckBox,3);
    }

    public void setCurrentAddress(String cAddress) {
        customWebElement.typeText(currentAddress,cAddress,2);
    }

    public WebElement setState() {
        return driver.findElement(By.xpath("//div[contains(@class, 'css-1wa3eu0-placeholder') and text()='Select State']"));
    }

    public void uploadFile(String filepath){
        customWebElement.typeText(uploadFileBtn,filepath,2);
    }

    public void clickSubmitBtn(){
        submitBtn.submit();
    }

    public static boolean isPhoneFieldHighlightedInRed(WebElement element){
        String borderColor = element.getCssValue("border-color");
        return borderColor.contains("#dc3545") || borderColor.contains("255, 0, 0") || borderColor.contains("red");
    }

    public static boolean isEmailFieldHighlightedInRed(WebElement element){
        String borderColor = element.getCssValue("border-color");
        return borderColor.contains("#dc3545") || borderColor.contains("255, 0, 0") || borderColor.contains("red");
    }

    public WebElement phoneField(){
        return driver.findElement(By.id("userEmail"));
    }
}
