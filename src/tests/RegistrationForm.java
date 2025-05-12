package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarRegistrationFormPage.CarRegistrationFormPage;

public class RegistrationForm extends BaseTest {

    //Sunny day scenarios
    @Test
    public void validRegistrationPlate() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("ABC5555");
        registrationPage.setYearDropdown("2016");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateSuccessMessage("Success! Selected ABC5555 with year 2016");
    }

    @Test
    public void invalidSubmissionAndThenASuccessfulOne() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("ABc5555");
        registrationPage.setYearDropdown("2016");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateFailedMessage("There was an error!");

        registrationPage.enterRegistrationPlate("XXX1234");
        registrationPage.setYearDropdown("2016");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateSuccessMessage("Success! Selected XXX1234 with year 2016");
    }

    // Rainy day scenarios
    @Test
    public void invalidRegistrationPlate_Reverted() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("5555XXX");
        registrationPage.setYearDropdown("2016");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateFailedMessage("There was an error!");
    }

    @Test
    public void invalidRegistrationPlate_LowCap() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("ABc5555");
        registrationPage.setYearDropdown("2016");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateFailedMessage("There was an error!");
    }

    public void invalidRegistrationPlate_LettersLength() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("ABCC5555");
        registrationPage.setYearDropdown("2016");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateFailedMessage("There was an error!");
    }

    @Test
    public void invalidRegistrationPlate_NumbersLength() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("ABC55555");
        registrationPage.setYearDropdown("2016");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateFailedMessage("There was an error!");
    }

    @Test
    public void invalidRegistrationPlate_WithHyphen() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("AB-5555");
        registrationPage.setYearDropdown("2016");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateFailedMessage("There was an error!");
    }

    @Test
    public void invalidRegistrationPlate_Empty() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("");
        registrationPage.setYearDropdown("2016");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateFailedMessage("There was an error!");
    }

    @Test
    public void invalidRegistrationPlateAndDropdown_BothEmpty() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("");
        registrationPage.setYearDropdown("");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateFailedMessage("There was an error!");
    }

    @Test
    public void invalidRegistrationDropdown_EmptyDropdown() {
        CarRegistrationFormPage registrationPage = new CarRegistrationFormPage(getDriver());
        registrationPage.enterRegistrationPlate("ABC5555");
        registrationPage.setYearDropdown("");
        registrationPage.clickSubmitButton();

        registrationPage.ValidateFailedMessage("There was an error!");
    }
}
