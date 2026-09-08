package Vinominds.SelinumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parallel_view_TG{

    WebDriver driver;

    // =================== SauceDemo ===================

    @Test(priority = 1)
    public void sauceDemoURL() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        System.out.println("SauceDemo URL Opened Successfully");
    }

    // =================== Test Automation Practice ===================

    @Test(priority = 2)
    public void automationPracticeURL() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        System.out.println("Test Automation Practice URL Opened Successfully");
    }

    // =================== Flipkart ===================

    @Test(priority = 3)
    public void flipkartURL() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.flipkart.com/");

        System.out.println("Flipkart URL Opened Successfully");
    }

    // =================== RedBus ===================

    @Test(priority = 4)
    public void redbusURL() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.redbus.in/");

        System.out.println("RedBus URL Opened Successfully");
    }
}