package Vinominds.SelinumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explictwait_swaglabs {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver dr = new ChromeDriver();

        dr.manage().window().maximize();

        dr.get("https://www.saucedemo.com/");

        // Create Explicit Wait - 10 seconds
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));

        // Enter username
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("user-name")))
                .sendKeys("standard_user");

        // Enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("password")))
                .sendKeys("secret_sauce");

        // Click Login button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("login-button")))
                .click();

        // Close browser
        dr.quit();
    }
}