package Vinominds.SelinumProject;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Randombutton {

    public static void main(String[] args) throws InterruptedException {

        
        WebDriverManager.chromedriver().setup();

        
        WebDriver driver = new ChromeDriver();

        
        driver.manage().window().maximize();

        
        driver.get("https://testautomationpractice.blogspot.com/");

        Thread.sleep(2000);

        
        Random random = new Random();

        

        int gender = random.nextInt(2);

        if (gender == 0) {

            WebElement male = driver.findElement(By.id("male"));

            if (!male.isSelected()) {
                male.click();
                System.out.println("Male Selected");
            }

        } else {

            WebElement female = driver.findElement(By.id("female"));

            if (!female.isSelected()) {
                female.click();
                System.out.println("Female Selected");
            }
        }

        Thread.sleep(2000);

        

        int day = random.nextInt(2);

        if (day == 0) {

            WebElement wednesday = driver.findElement(By.id("wednesday"));

            if (!wednesday.isSelected()) {
                wednesday.click();
                System.out.println("Wednesday Selected");
            }

        } else {

            WebElement thursday = driver.findElement(By.id("thursday"));

            if (!thursday.isSelected()) {
                thursday.click();
                System.out.println("Thursday Selected");
            }
        }

        Thread.sleep(5000);

        
        driver.quit();
    }
}