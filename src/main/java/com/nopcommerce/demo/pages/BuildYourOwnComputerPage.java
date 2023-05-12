package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class BuildYourOwnComputerPage extends Utility {
    //Build your own computer Text, Processor Drop Down, Ram drop down,
    //  HDD radios, os radio, software check boxes, Add To Card button, "The product has been added to your shopping cart"
    //  message locators and it's actions
    @FindBy(xpath = "//h1")
    WebElement headingText;

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputer;

    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement processorOption;

    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement RAMLink;

    @CacheLookup
    @FindBy(name = "product_attribute_3")
    List<WebElement> hddRadio;

    @CacheLookup
    @FindBy(name = "product_attribute_4")
    List<WebElement> osLink;

    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_5_10']")
    WebElement checkboxLink1;

    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> checkboxLink;

    @CacheLookup
    @FindBy(id = "price-value-1")
    WebElement priceLink;

    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement successMessageLink;

    @CacheLookup
    @FindBy(xpath = "//span[@title='Close']")
    WebElement closeLink;

    @CacheLookup
    @FindBy(xpath = "//span[@class='cart-label']")
    public WebElement shoppingCartLink;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Go to cart'])[1]")
    WebElement goToCartLink;


    public void clickOnBuildYourOwnComputer(){
        clickOnElement(buildYourOwnComputer);
    }

    public String getTextForBuildYourOwnComputer(){
        return getTextFromElement(buildYourOwnComputer);
    }

    public void selectProcessor(String processor){
        CustomListeners.test.log(Status.PASS, "Select " + processorOption);
        Reporter.log("Select " + processorOption.toString());
        selectByVisibleTextFromDropDown(processorOption,processor);
    }

    public void selectRAM(String ram){
        selectByVisibleTextFromDropDown(RAMLink,ram);
        CustomListeners.test.log(Status.PASS, "Select " + RAMLink);
        Reporter.log("Select " + RAMLink.toString());
    }
    public void selectHddRadio(String radio){
        CustomListeners.test.log(Status.PASS, "Select " + hddRadio);
        Reporter.log("Select " + hddRadio.toString());
        List<WebElement> hddRadios=getListOfElements(hddRadio);
        String val = "320 GB";
        String val1="400 GB [+$100.00]";
        if (val.equalsIgnoreCase(radio)) {
            hddRadios.get(0).click();
        }else if(val1.equalsIgnoreCase(radio)){
            hddRadios.get(1).click();
        }
    }
    public void selectOs(String os){
        CustomListeners.test.log(Status.PASS, "Select " + osLink);
        Reporter.log("Select " + osLink.toString());
        List<WebElement> osOption=getListOfElements(osLink);
        String val = "Vista Home [+$50.00]";
        String val1="Vista Premium [+$60.00]";
        if (val.equalsIgnoreCase(os)) {
            osOption.get(0).click();
        }else if(val1.equalsIgnoreCase(os)){
            osOption.get(1).click();
        }
    }
    public void selectCheckBox(String software){
        CustomListeners.test.log(Status.PASS, "Select " + checkboxLink);
        Reporter.log("Select " + checkboxLink.toString());
        List<WebElement> softwareOption=getListOfElements(checkboxLink);
        String val = "Microsoft Office [+$50.00]";
        String val1 = "Acrobat Reader [+$10.00]";
        String val2 = "Total Commander [+$5.00]";
        if (val.equalsIgnoreCase(software)) {
            softwareOption.get(0).click();
            softwareOption.get(0).click();
        }else if(val1.equalsIgnoreCase(software)){
            softwareOption.get(0).click();
            softwareOption.get(1).click();
        }else if(val2.equalsIgnoreCase(software)){
            softwareOption.get(0).click();
            softwareOption.get(2).click();
        }
    }
    public void selectCheckBox1(){
        clickOnElement(checkboxLink1);
        CustomListeners.test.log(Status.PASS, "Select " + checkboxLink1);
        Reporter.log("Select " + checkboxLink1.toString());
    }
    public String getPrice(){
        CustomListeners.test.log(Status.PASS, "Get price " + priceLink);
        Reporter.log("Get price " + priceLink.toString());
        return getTextFromElement(priceLink);
    }
    public String getSuccessMessage(){
        CustomListeners.test.log(Status.PASS, "Get message " + successMessageLink);
        Reporter.log("Get message " + successMessageLink.toString());
        return getTextFromElement(successMessageLink);
    }
    public void closeMessage(){
        clickOnElement(closeLink);
        CustomListeners.test.log(Status.PASS, "Click on " + closeLink);
        Reporter.log("Click on " + closeLink.toString());
    }
    public void clickOnGoToCart(){
        clickOnElement(goToCartLink);
        CustomListeners.test.log(Status.PASS, "Click on " + goToCartLink);
        Reporter.log("Click on " + goToCartLink.toString());
    }
    public String getHeadingText(){
        CustomListeners.test.log(Status.PASS, "Get text " + headingText);
        Reporter.log("Get text " + headingText.toString());
        return getTextFromElement(headingText);
    }
}
