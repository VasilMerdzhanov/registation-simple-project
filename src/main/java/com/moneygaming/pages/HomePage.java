package com.moneygaming.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(css = ".newUser.green")
    private WebElement joinNowButton;

    public HomePage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get("https://moneygaming.qa.gameaccount.com/");
    }

    public void clickJoinNowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(joinNowButton)).click();
    }
}