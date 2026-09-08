package Vinominds.SelinumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class S2_grouping {

    WebDriver driver;

    // alwaysRun = true allows setup to execute when groups are included in XML
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        System.out.println("Browser launched");
    }

    @Test(groups = {"smoke"})
    public void validLoginTest() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Valid login");
    }

    @Test(groups = {"sanity"})
    public void invalidLoginTest() {
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("invalid_password");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Invalid login");
    }

    @Test(groups = {"regression"})
    public void emptyUsernameTest() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Empty username validation");
    }

    @Test(groups = {"pongal"})
    public void pongalTest() {
        System.out.println("Pongal test executed");
    }

    // alwaysRun = true allows teardown to close browser after group runs
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
        System.out.println("Browser closed");
    }
}