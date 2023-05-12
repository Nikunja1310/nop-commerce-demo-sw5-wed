package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {
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
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
    homePage.selectMenu("Computers");
    softAssert(computerPage.getComputerText(),"Computers","Not verified");
    }

    @Test(groups = {"sanity"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.selectMenu("Computers");
        computerPage.mouseHoverToDesktop();
        softAssert(computerPage.getDesktopText(),"Desktops","Not verified!");
    }

    @Test(groups = {"regression"}, dataProvider = "selection", dataProviderClass = TestData.class)
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(
            String processor, String ram, String hdd, String os, String software){

        homePage.selectMenu("Computers");
        computerPage.mouseHoverToDesktop();
        buildYourOwnComputerPage.clickOnBuildYourOwnComputer();
        buildYourOwnComputerPage.selectProcessor(processor);
        buildYourOwnComputerPage.selectRAM(ram);
        buildYourOwnComputerPage.selectHddRadio(hdd);
        buildYourOwnComputerPage.selectOs(os);
        buildYourOwnComputerPage.selectCheckBox(software);
        buildYourOwnComputerPage.clickOnGoToCart();
        Assert.assertEquals(buildYourOwnComputerPage.getSuccessMessage(),"The product has been added to your shopping cart","Product is not added successfully");

    }

}
