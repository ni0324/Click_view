package Vinominds.SelinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Locator
    By productsTitle = By.className("title");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method
    public String getProductsTitle() {
        return driver.findElement(productsTitle).getText();
    }
}