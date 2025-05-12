package pages.CarRegistrationFormPage;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CarRegistrationFormPage {
    private final WebDriver driver;

    // Elements
    @FindBy(id = "input-number-plates")
    public WebElement numberPlates;

    @FindBy(id = "select-year")
    public WebElement yearDropdown;

    @FindBy(id = "btn-submit")
    public WebElement SubmitBtn;

    @FindBy(css = "div[class='alert alert-success']")
    public WebElement SuccessMessage;

    @FindBy(css = "div[class='alert alert-danger']")
    public WebElement FailedMessage;

    // Methods
    public void enterRegistrationPlate(String regPlate) {
        numberPlates.clear();
        numberPlates.sendKeys(regPlate);
    }

    public void setYearDropdown(String year) {
        Select yearSelect = new Select(yearDropdown);
        if (!year.isEmpty()) {
            yearSelect.selectByVisibleText(year);
        }
    }

    public void clickSubmitButton() {
        SubmitBtn.click();
    }

    // Validations
    public void ValidateSuccessMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, SuccessMessage.getText());
    }

    public void ValidateFailedMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, FailedMessage.getText());
    }

    // Initialization
    public CarRegistrationFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
