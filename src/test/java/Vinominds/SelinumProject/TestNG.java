package Vinominds.SelinumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG {

    WebDriver driver;

    // =================== SauceDemo ===================

    @Test(priority = 1)
    public void launch() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 2)
    public void login() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("SauceDemo Launch Validation Passed");
        } else {
            System.out.println("SauceDemo Launch Validation Failed");
        }
    }

    @Test(priority = 3)
    public void validUsername() {
        System.out.println("SauceDemo Username Validation Passed");
    }

    @Test(priority = 4)
    public void validPassword() {
        System.out.println("SauceDemo Password Validation Passed");
    }

    @Test(priority = 5)
    public void exit() {
        driver.quit();
    }

    // =================== Test Automation Practice ===================

    @Test(priority = 6)
    public void launch1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test(priority = 7)
    public void login1() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Testing Practice";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Automation Practice Validation Passed");
        } else {
            System.out.println("Test Automation Practice Validation Failed");
        }
    }

    @Test(priority = 8)
    public void validUsername1() {
        System.out.println("Test Automation Username Validation Passed");
    }

    @Test(priority = 9)
    public void validPassword1() {
        System.out.println("Test Automation Password Validation Passed");
    }

    @Test(priority = 10)
    public void exit1() {
        driver.quit();
    }

    // =================== Flipkart ===================

    @Test(priority = 11)
    public void launch2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
    }

    @Test(priority = 12)
    public void login2() {

        String actualTitle = driver.getTitle();

        if (actualTitle.contains("Online Shopping")) {
            System.out.println("Flipkart Validation Passed");
        } else {
            System.out.println("Flipkart Validation Failed");
        }
    }

    @Test(priority = 13)
    public void validUsername2() {
        System.out.println("Flipkart Username Validation Passed");
    }

    @Test(priority = 14)
    public void validPassword2() {
        System.out.println("Flipkart Password Validation Passed");
    }

    @Test(priority = 15)
    public void exit2() {
        driver.quit();
    }

    // =================== RedBus ===================

    @Test(priority = 16)
    public void launch3() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
    }

    @Test(priority = 17)
    public void login3() {

        String actualTitle = driver.getTitle();

        if (actualTitle.contains("Bus")) {
            System.out.println("RedBus Validation Passed");
        } else {
            System.out.println("RedBus Validation Failed");
        }
    }

    @Test(priority = 18)
    public void validUsername3() {
        System.out.println("RedBus Username Validation Passed");
    }

    @Test(priority = 19)
    public void validPassword3() {
        System.out.println("RedBus Password Validation Passed");
    }

    @Test(priority = 20)
    public void exit3() {
        driver.quit();
    }

}