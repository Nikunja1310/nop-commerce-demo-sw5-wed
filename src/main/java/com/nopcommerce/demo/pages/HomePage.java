package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    //HomePage - All Menu (Seven menu), LoginLink, registerLink, nopcommerce logo, My account link and LogOut link locatores
    //  and create appropriate methods for it

    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']//ul/child::*")
    List<WebElement> topMenuBar;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[1]/div[2]/div[1]/a[1]/img[1]")
    WebElement nopcommerceLogo;

     @CacheLookup
     @FindBy(xpath = "")
     WebElement myAccountLink;

     @CacheLookup
     @FindBy(xpath = "//a[@class='ico-logout']")
     WebElement logoutLink;


    public void selectMenu(String menu) {
        CustomListeners.test.log(Status.PASS, "Hover over menu " + topMenuBar);
        Reporter.log("Hover over menu " + topMenuBar.toString());

        List<WebElement> topMenuList = topMenuBar;
        try {
            for (WebElement list : topMenuList) {
                if (list.getText().equalsIgnoreCase(menu)) {
                    list.click();
                    break;
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenuBar;
        }
    }

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS,"Click on Login Link");
        Reporter.log("Click on Login Link");
    }
    public void clickOnRegisterLink(){
        CustomListeners.test.log(Status.PASS,"Click on Register Link");
        Reporter.log("Click on Register Link");
        clickOnElement(registerLink);
    }

    public boolean nopcommerceLogoDisplayed(){
       return nopcommerceLogo.isDisplayed();
    }

    public void clickOnMyAccountLink(){
        clickOnElement(myAccountLink);
    }

    public String getTextLogoutLink(){
       return getTextFromElement(logoutLink);
    }

}