package com.moneygaming.tests;

import com.moneygaming.pages.HomePage;
import com.moneygaming.pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + UUID.randomUUID());
        driver = new ChromeDriver(options);
    }

    @Test
    public void testRegistration() {
    	System.out.println("Navigating to home page...");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        System.out.println("Clicking JOIN NOW button...");
        homePage.clickJoinNowButton();

        System.out.println("Filling registration form...");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.selectTitle("Mr");
        registrationPage.enterFirstName("Vasil");
        registrationPage.enterSurname("Merdzhanov");
        registrationPage.acceptTermsAndConditions();
        
        System.out.println("Submitting the form...");
        registrationPage.clickJoinNowButton();

        System.out.println("Validating the error message...");
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