package Vinominds.SelinumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Class_TG_DUP {

    WebDriver driver;

    // Test data
    String url = "https://www.saucedemo.com/";
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";
    String invalidUsername = "12standard_userBB";
    String invalidPassword = "13secret_sauceAA";
    String expectedTitle = "Products";
    String expectedErrorMessage =
            "Epic sadface: Username and password do not match any user in this service.";

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @BeforeMethod
    public void openWebsite() {

        driver.get(url);
    }

    @Test
    public void loginTest() {

        driver.findElement(By.id("user-name"))
              .sendKeys(validUsername);

        driver.findElement(By.id("password"))
              .sendKeys(validPassword);

        driver.findElement(By.id("login-button"))
              .click();

        String title = driver.findElement(By.className("title"))
                             .getText();

        Assert.assertEquals(title, expectedTitle);

        System.out.println("Valid Login Test Passed");
    }

    @Test
    public void invalidUsernameInvalidPassword() {

        driver.findElement(By.id("user-name"))
              .sendKeys(invalidUsername);

        driver.findElement(By.id("password"))
              .sendKeys(invalidPassword);

        driver.findElement(By.id("login-button"))
              .click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']"))
                                    .getText();

        Assert.assertEquals(errorMessage, expectedErrorMessage);

        System.out.println("Invalid Login Test Passed");
    }

    @AfterClass
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed");
    }
}