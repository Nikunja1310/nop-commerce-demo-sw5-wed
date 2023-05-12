package com.nopcommerce.demo.pages;
import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {
//Register Text, male female radio, Firstname, lastname, Date of Birth drop downs, email,
//  Password, Confirm Password, Register Button, "First name is required.","Last name is required.",
//  "Email is required.","Password is required.", "Password is required." error message,
//  "Your registration completed" message, "CONTINUE" button
//  Locators and it's actions


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;


    @CacheLookup
    @FindBy(xpath = "//input[@name='Gender' and @value='F']")
    WebElement femaleRadio;


    @CacheLookup
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameField;


    @CacheLookup
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameField;


    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement monthField;


    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement yearField;


    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dateField;


    @CacheLookup
    @FindBy(xpath = "//input[contains(@id,'E')]")
    WebElement emailField;


    @CacheLookup
    @FindBy(xpath = "//input[@name='Password']")
    WebElement passwordField;


    @CacheLookup
    @FindBy(xpath = "//input[@name='ConfirmPassword']")
    WebElement confirmPasswordField;


    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement registerButton;


    @CacheLookup
    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstNameIsRequired;


    @CacheLookup
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameIsRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement passwordRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement confirmPasswordRequired;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Your registration completed']")
    WebElement yourRegistrationCompleted;


    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;


    public void getRegisterText(){
        getTextFromElement(registerText);
    }

    public void selectGenderRadioButton(){
        CustomListeners.test.log(Status.PASS,"Select Female Gender ");
        Reporter.log("Select Radio button " + femaleRadio.toString());
        clickOnElement(femaleRadio);
    }


    public void enterFirstName(String firstName) {
        CustomListeners.test.log(Status.PASS, "Enter First name " + firstName + " in firstName field.");
        Reporter.log("Enter First name : " + firstName + " in first name field " + firstNameField.toString());
        sendTextToElement(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        CustomListeners.test.log(Status.PASS, "Enter Last name " + lastName + " in last name field.");
        Reporter.log("Enter Last name : " + lastName + " in email field " + lastNameField.toString());
        sendTextToElement(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        CustomListeners.test.log(Status.PASS, "Enter Email id " + email + " in email field.");
        Reporter.log("Enter Email : " + email + " in email field " + emailField.toString());
        sendTextToElement(emailField, email);
    }


    public void enterPassword(String password) {
        CustomListeners.test.log(Status.PASS, "Enter password " + password + " in password field.");
        Reporter.log("Enter password : " + password + "in password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        CustomListeners.test.log(Status.PASS, "Enter password " + confirmPassword + " in password field.");
        Reporter.log("Enter password : " + confirmPassword + "in password field " + confirmPasswordField.toString());
        sendTextToElement(confirmPasswordField, confirmPassword);
    }

    public void clickOnRegisterButton() {
        CustomListeners.test.log(Status.PASS, "Click on Register button");
        Reporter.log("Click on Register button" + registerButton.toString());
        clickOnElement(registerButton);
    }

    public String getFirstNameIsRequiredText() {
       return getTextFromElement(firstNameIsRequired);
    }

    public String getLastNameIsRequiredText() {
        return getTextFromElement(lastNameIsRequired);
    }

    public String getEmailIsRequired(){
        return getTextFromElement(emailRequired);
    }

    public String getPasswordIsRequired(){
        return getTextFromElement(passwordRequired);
    }

    public String getConfirmPasswordIsRequired(){
        return getTextFromElement(confirmPasswordRequired);
    }

    public String getYourRegistrationCompletedText() {
        return getTextFromElement(yourRegistrationCompleted);
    }


    public void clickOnContinueButton() {
        CustomListeners.test.log(Status.PASS, "Click on Continue button");
        Reporter.log("Click on Continue button" + continueButton.toString());
        clickOnElement(continueButton);
    }

    public void selectDate(String date){
        selectByVisibleTextFromDropDown(dateField, date);
    }

    public void selectMonth(String month){
        selectByVisibleTextFromDropDown(monthField,month);
    }

    public void selectYear(String year){
        selectByVisibleTextFromDropDown(yearField,year);
    }

}
