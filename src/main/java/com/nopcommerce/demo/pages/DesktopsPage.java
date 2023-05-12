package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopsPage extends Utility {
    //Desktops text, SortBy, Display, selectProductList Locators and it's actions
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement sortBy;

    @CacheLookup
    @FindBy(xpath = "//select[@id='products-pagesize']")
    WebElement display;

    public void getDesktopText(){
        Reporter.log("Getting Desktop Text " + desktopsText.toString());
        CustomListeners.test.log(Status.PASS,"Getting Desktop Text");
        getTextFromElement(desktopsText);
    }

    public void selectSortBy(String sort){
        selectByVisibleTextFromDropDown(sortBy,sort);
    }

    public void selectDisplay(String page){
        selectByVisibleTextFromDropDown(display, page);
    }

}
