package Vinominds.SelinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open Website
        driver.get("https://testautomationpractice.blogspot.com/");

        Thread.sleep(2000);

        // Male Radio Button
        WebElement male = driver.findElement(By.id("male"));
        if (!male.isSelected()) {
            male.click();
            System.out.println("Male Selected");
        }

        Thread.sleep(1000);

        // Female Radio Button
        WebElement female = driver.findElement(By.id("female"));
        if (!female.isSelected()) {
            female.click();
            System.out.println("Female Selected");
        }

        Thread.sleep(1000);

        // Monday Checkbox
        WebElement monday = driver.findElement(By.id("monday"));
        if (!monday.isSelected()) {
            monday.click();
            System.out.println("Monday Selected");
        }

        Thread.sleep(1000);

        // Tuesday Checkbox
        WebElement tuesday = driver.findElement(By.id("tuesday"));
        if (!tuesday.isSelected()) {
            tuesday.click();
            System.out.println("Tuesday Selected");
        }

        Thread.sleep(3000);

        driver.quit();
    }
}