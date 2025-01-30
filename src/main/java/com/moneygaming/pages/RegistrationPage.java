package com.moneygaming.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{

    @FindBy(id = "title")
    private WebElement titleDropdown;

    @FindBy(id = "forename")
    private WebElement firstNameField;

    @FindBy(name = "map(lastName)")
    private WebElement surnameField;

    @FindBy(css = "input[name='map(dobDay)']")
    private WebElement dobDayField;

    @FindBy(css = "input[name='map(dobMonth)']")
    private WebElement dobMonthField;

    @FindBy(css = "input[name='map(dobYear)']")
    private WebElement dobYearField;

    @FindBy(css = "input[name='map(terms)']")
    private WebElement termsCheckbox;

    @FindBy(css = "input[value='Join Now!']")
    private WebElement joinNowButton;

    @FindBy(css = "label[for='dob']")
    private WebElement dobValidationMessage;

    public RegistrationPage(WebDriver driver) {
    	super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectTitle(String title) {
        new Select(titleDropdown).selectByVisibleText(title);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterSurname(String surname) {
        surnameField.sendKeys(surname);
    }

    public void acceptTermsAndConditions() {
        termsCheckbox.click();
    }

    public void clickJoinNowButton() {
        joinNowButton.click();
    }

    public String getDobValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOf(dobValidationMessage)).getText();
    }
}
