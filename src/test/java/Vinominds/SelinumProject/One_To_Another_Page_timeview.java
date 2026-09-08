package Vinominds.SelinumProject;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class One_To_Another_Page_timeview {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver dr = new ChromeDriver();

        dr.manage().window().maximize();

        // Implicit Wait - 1 Minute
        dr.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));

        // Open Swag Labs
        dr.get("https://www.saucedemo.com/");

        // Username
        dr.findElement(By.id("user-name"))
          .sendKeys("standard_user");

        // Password
        dr.findElement(By.id("password"))
          .sendKeys("secret_sauce");

        // Login
        dr.findElement(By.id("login-button"))
          .click();

        // Burger Menu
        dr.findElement(By.id("react-burger-menu-btn"))
          .click();

        // About
        dr.findElement(By.linkText("About"))
          .click();

        Thread.sleep(5000);

        dr.quit();
    }
}