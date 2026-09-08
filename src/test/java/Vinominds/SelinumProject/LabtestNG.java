package Vinominds.SelinumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LabtestNG {

    WebDriver driver;

    String username = "standard_user";
    String password = "secret_sauce";

    @Test(priority = 1)
    public void launch() throws Exception {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(3000);

        System.out.println("Website Launched Successfully");
    }

    @Test(priority = 2, dependsOnMethods = "launch")
    public void login() throws Exception {

        driver.findElement(By.id("user-name"))
              .sendKeys(username);

        Thread.sleep(2000);

        driver.findElement(By.id("password"))
              .sendKeys(password);

        Thread.sleep(2000);

        driver.findElement(By.id("login-button"))
              .click();

        Thread.sleep(3000);

        System.out.println("Login Button Clicked");
    }

    @Test(priority = 3, dependsOnMethods = "login")
    public void validUsername() throws Exception {

        Thread.sleep(2000);

        if (username.equals("standard_user")) {

            System.out.println("Username is Valid");

        } else {

            System.out.println("Username is Invalid");
        }
    }

    @Test(priority = 4, dependsOnMethods = "login")
    public void validPassword() throws Exception {

        Thread.sleep(2000);

        if (password.equals("secret_sauce")) {

            System.out.println("Password is Valid");

        } else {

            System.out.println("Password is Invalid");
        }
    }

    @Test(priority = 5, dependsOnMethods = {"validUsername", "validPassword"})
    public void exit() throws Exception {

        Thread.sleep(3000);

        if (driver.getCurrentUrl().contains("inventory")) {

            System.out.println("Login Successful");

        } else {

            System.out.println("Login Failed");
        }

        Thread.sleep(3000);

        driver.quit();

        System.out.println("Browser Closed");
    }
}