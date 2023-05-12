package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    BuildYourOwnComputerPage buildYourOwnComputerPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"smoke"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        homePage.clickOnRegisterLink();
        registerPage.getRegisterText();
    }

    @Test(groups = {"sanity"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandetory() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        softAssert(registerPage.getFirstNameIsRequiredText(),"First name is required.","Error message not displayed");
        softAssert(registerPage.getLastNameIsRequiredText(),"Last name is required.","Error message not displayed");
        softAssert(registerPage.getEmailIsRequired(),"Email is required.","Error message not displayed");
        softAssert(registerPage.getPasswordIsRequired(),"Password is required.","Error message not displayed");
        softAssert(registerPage.getConfirmPasswordIsRequired(),"Password is required.","Error message not displayed");
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldCreateAccountSuccessfully(){
        homePage.clickOnRegisterLink();
        registerPage.selectGenderRadioButton();
        registerPage.enterFirstName("Nikki");
        registerPage.enterLastName("Senja");
        registerPage.selectDate("13");
        registerPage.selectMonth("October");
        registerPage.selectYear("1991");
        registerPage.enterPassword("Nikunja123");
        registerPage.enterConfirmPassword("Nikunja123");
        registerPage.enterEmail("nikkisen13@gmail.com");
        registerPage.clickOnRegisterButton();
    }
}
