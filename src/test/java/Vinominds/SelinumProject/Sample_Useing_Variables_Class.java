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

public class Sample_Useing_Variables_Class {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        // Setup Chrome
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        // Implicit Wait - 60 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @BeforeMethod
    public void openWebsite() {

        // Open SauceDemo
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest() {

        // Enter Username
        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        // Enter Password
        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        // Click Login
        driver.findElement(By.id("login-button"))
              .click();

        // Get Products title
        String title = driver.findElement(By.className("title"))
                             .getText();

        // Verify Products page
        Assert.assertEquals(title, "Products");

        System.out.println("Login Test Passed");
    }
    

    @AfterClass
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed");
    }
}