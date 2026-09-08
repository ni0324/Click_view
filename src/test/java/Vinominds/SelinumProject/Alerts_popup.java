package Vinominds.SelinumProject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts_popup {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void alertTest() throws InterruptedException {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(
                By.xpath("//button[text()='Click for JS Alert']")
        ).click();

        Alert alert = driver.switchTo().alert();

        Thread.sleep(2000);

        alert.dismiss();

        System.out.println("Alert closed");
    }

    @Test
    public void confirmTest() throws InterruptedException {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(
                By.xpath("//button[text()='Click for JS Confirm']")
        ).click();

        Alert alert = driver.switchTo().alert();

        Thread.sleep(2000);

        alert.dismiss();

        System.out.println("Confirm closed");
    }

    @Test
    public void promptTest() throws InterruptedException {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(
                By.xpath("//button[text()='Click for JS Prompt']")
        ).click();

        Alert alert = driver.switchTo().alert();

        // Keep popup visible for 2 seconds
        Thread.sleep(2000);

        // Automatically type Nish
        alert.sendKeys("Nish");

        // Keep Nish visible for 2 seconds
        Thread.sleep(2000);

        // Automatically click OK
        alert.accept();

        System.out.println("Prompt closed");
    }

    @AfterMethod
    public void close() {

        driver.quit();

        System.out.println("Browser closed");
    }
}