package Vinominds.SelinumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TG_2_Dataentry {

    WebDriver driver;

    @BeforeMethod
    public void launchBrowser() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void FillDataEntryForm() throws Exception {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("name")).sendKeys("Juan");

        Thread.sleep(1000);

        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");

        Thread.sleep(1000);

        driver.findElement(By.id("phone")).sendKeys("9876543210");

        Thread.sleep(1000);

        driver.findElement(By.id("textarea")).sendKeys("Coimbatore, Tamil Nadu");

        Thread.sleep(1000);

        driver.findElement(By.id("male")).click();

        Thread.sleep(1000);

        driver.findElement(By.id("sunday")).click();
        driver.findElement(By.id("monday")).click();
        driver.findElement(By.id("tuesday")).click();

        Thread.sleep(1000);

        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("India");

        Thread.sleep(1000);
    }

    @AfterMethod
    public void closeBrowser() throws Exception {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Thread.sleep(1000);

        driver.quit();
    }
}
