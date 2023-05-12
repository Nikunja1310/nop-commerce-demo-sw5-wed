package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//a[@class='ico-login']")
  public   WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    public void enterEmail(String email){
        CustomListeners.test.log(Status.PASS,"Enter Email id " + email + " in email field.");
        Reporter.log("Enter Email : " + email +" in email field " + emailField.toString() );
        sendTextToElement(emailField,email);
    }


    public void enterPassword(String password){
        CustomListeners.test.log(Status.PASS,"Enter password " + password + " in password field.");
        Reporter.log("Enter password : " + password + "in password field " +passwordField.toString());
        sendTextToElement(passwordField,password);
    }

    public void clickOnLoginButton(){
        CustomListeners.test.log(Status.PASS,"Click on Login button");
        Reporter.log("Click on Login button");
        clickOnElement(loginButton);
    }

    public String getWelcomeText(){
        CustomListeners.test.log(Status.PASS,"Getting Welcome Text for verifying ");
        Reporter.log("Getting welcome text " + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public String getErrorMessage(){
        CustomListeners.test.log(Status.PASS,"Getting Error message");
        Reporter.log("Getting error message " + errorMessage.toString());
        return getTextFromElement(errorMessage);
    }
}
