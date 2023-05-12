package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Computers'])[1]")
    WebElement computersLink;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Desktops']")
    WebElement desktopsLink;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Notebooks'])[1]")
    WebElement notebooksLink;

    @CacheLookup
    @FindBy(xpath = "(//a[normalize-space()='Software'])[1]")
    WebElement softwareLink;


    public void clickOnComputer(){
        clickOnElement(computersLink);
    }

    public void mouseHoverToDesktop(){
        mouseHoverToElementAndClick(desktopsLink);
    }
    public void mouseHoverToNotebooks(){
        mouseHoverToElementAndClick(notebooksLink);
    }

    public void mouseHoverToSoftwareLink(){
        mouseHoverToElementAndClick(softwareLink);
    }
    public String getComputerText(){
       return getTextFromElement(computerText);
    }

    public String getDesktopText(){
        return getTextFromElement(desktopText);
    }

}
