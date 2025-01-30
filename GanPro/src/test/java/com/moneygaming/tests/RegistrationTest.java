package com.moneygaming.tests;

import com.moneygaming.pages.HomePage;
import com.moneygaming.pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRegistration() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.clickJoinNowButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.selectTitle("Mr");
        registrationPage.enterFirstName("Vasil");
        registrationPage.enterSurname("Merdzhanov");
        registrationPage.acceptTermsAndConditions();
        registrationPage.clickJoinNowButton();

        String validationMessage = registrationPage.getDobValidationMessage();
        Assert.assertEquals(validationMessage, "This field is required");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}