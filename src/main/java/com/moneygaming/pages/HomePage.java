package com.moneygaming.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

//    private WebDriver driver;
//    private WebDriverWait wait;

    @FindBy(css = ".newUser.green")
    private WebElement joinNowButton;

    public HomePage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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