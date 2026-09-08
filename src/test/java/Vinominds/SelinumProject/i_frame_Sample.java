package Vinominds.SelinumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class i_frame_Sample {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get("https://demoqa.com/frames");
    }

    @Test
    public void iframeTest() throws InterruptedException {

        
        Thread.sleep(2000);

        
        driver.switchTo().frame("frame1");

        
        WebElement frame1Heading = driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame 1 Text: " + frame1Heading.getText());

        
        Thread.sleep(2000);

        
        driver.switchTo().defaultContent();

        
        driver.switchTo().frame("frame2");

        
        WebElement frame2Heading = driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame 2 Text: " + frame2Heading.getText());

        
        Thread.sleep(2000);

        
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        
        Thread.sleep(2000);

        if (driver != null) {
            driver.quit();
        }
    }
}