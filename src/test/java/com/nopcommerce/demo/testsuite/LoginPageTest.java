package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
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
    public void userShouldNavigateToLoginPageSuccessFully() {
        homePage.clickOnLoginLink();
        softAssert(loginPage.getWelcomeText(), "Welcome, Please Sign In!", "Verification Error");

    }


    @Test(groups = {"sanity"})
    public void verifyTheErrorMessageWithInValidCredentials() throws InterruptedException {
        homePage.clickOnLoginLink();
        loginPage.enterEmail("nikkisen13@gmail.c");
        loginPage.enterPassword("Nikunja123");
        loginPage.clickOnLoginButton();
       // Assert.assertTrue(loginPage.getErrorMessage().contains("unsuccessful"),"Error message not displayed");
         softAssert(loginPage.getErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                  "No customer account found","Error message not displayed");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() throws InterruptedException {
        homePage.clickOnLoginLink();
        loginPage.enterEmail("nikkisen13@gmail.com");
        loginPage.enterPassword("Nikunja123");
        Thread.sleep(2000);
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        loginPage.getErrorMessage();

    }


    @Test(groups = {"sanity","smoke"})
    public void VerifyThatUserShouldLogOutSuccessFully (){
        homePage.clickOnLoginLink();
        loginPage.enterEmail("nikkisen13@gmail.com");
        loginPage.enterPassword("Nikunja123");
        loginPage.clickOnLoginButton();
        loginPage.loginButton.isDisplayed();
    }
}
