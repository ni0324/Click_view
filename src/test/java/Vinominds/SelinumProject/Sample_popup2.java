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

public class Sample_popup2 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        System.out.println("Browser opened");
    }

    @Test
    public void alertTest() {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        System.out.println("Alert closed automatically");
    }

    @Test
    public void confirmTest() {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        System.out.println("Confirm closed automatically");
    }

    @Test
    public void promptTest() throws InterruptedException {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alert = driver.switchTo().alert();

        
        Thread.sleep(1000);

        alert.sendKeys("Nish");

        
        Thread.sleep(2000);

        alert.accept();

        System.out.println("Prompt entered Nish and closed");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(1000);
        driver.quit();

        System.out.println("Browser closed");
    }
}