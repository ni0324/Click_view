package Vinominds.SelinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class navigation {

    public static void main(String[] args) throws Exception {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Maximize Browser
        driver.manage().window().maximize();

        // Open First Website
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("First URL : " + driver.getCurrentUrl());

        Thread.sleep(3000);

        // Locate Country Dropdown
        WebElement dropdownelement = driver.findElement(By.id("country"));
        Select select = new Select(dropdownelement);

        // Select by Visible Text
        select.selectByVisibleText("United States");
        Thread.sleep(2000);

        select.selectByVisibleText("Canada");
        Thread.sleep(2000);

        select.selectByVisibleText("United Kingdom");
        Thread.sleep(2000);

        select.selectByVisibleText("Germany");
        Thread.sleep(2000);

        select.selectByVisibleText("France");
        Thread.sleep(2000);

        select.selectByVisibleText("Australia");
        Thread.sleep(2000);

        select.selectByVisibleText("Japan");
        Thread.sleep(2000);

        select.selectByVisibleText("China");
        Thread.sleep(2000);

        select.selectByVisibleText("Brazil");
        Thread.sleep(2000);

        select.selectByVisibleText("India");
        Thread.sleep(3000);

        // Select by Index
        select.selectByIndex(0);
        Thread.sleep(1000);

        select.selectByIndex(1);
        Thread.sleep(1000);

        select.selectByIndex(2);
        Thread.sleep(1000);

        select.selectByIndex(3);
        Thread.sleep(1000);

        select.selectByIndex(4);
        Thread.sleep(1000);

        select.selectByIndex(5);
        Thread.sleep(1000);

        select.selectByIndex(6);
        Thread.sleep(1000);

        select.selectByIndex(7);
        Thread.sleep(1000);

        select.selectByIndex(8);
        Thread.sleep(1000);

        select.selectByIndex(9);
        Thread.sleep(3000);

        // Navigate to Second Website
        driver.navigate().to("https://pavanonlinetrainings.com/#udemy");
        System.out.println("Second URL : " + driver.getCurrentUrl());

        Thread.sleep(3000);

        // Navigate Back
        driver.navigate().back();
        System.out.println("After Back : " + driver.getCurrentUrl());

        Thread.sleep(3000);

        // Navigate Forward
        driver.navigate().forward();
        System.out.println("After Forward : " + driver.getCurrentUrl());

        Thread.sleep(3000);

        // Refresh Page
        driver.navigate().refresh();
        System.out.println("Page Refreshed");

        Thread.sleep(3000);

        driver.quit();
    }
}