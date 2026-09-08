package Vinominds.SelinumProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllBA_TG1 {

    WebDriver driver;
    String password = "secret_sauce";

    @BeforeMethod
    public void launchBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get("https://www.saucedemo.com/");

    }

    public void login(String username) throws Exception {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        Thread.sleep(1000);

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(1000);

    }

    public void logout() throws Exception {

    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        try {

            driver.findElement(By.id("react-burger-menu-btn")).click();

            Thread.sleep(2000);

            driver.findElement(By.id("logout_sidebar_link")).click();

            Thread.sleep(2000);

        } catch (Exception e) {

            System.out.println("Logout not possible for this user.");

        }

    }

    @Test(priority = 1)
    public void standardUser() throws Exception {

        login("standard_user");
        logout();

    }

    @Test(priority = 2)
    public void lockedOutUser() throws Exception {

        login("locked_out_user");

    }

    @Test(priority = 3)
    public void problemUser() throws Exception {

        login("problem_user");
        logout();

    }

    @Test(priority = 4)
    public void performanceGlitchUser() throws Exception {

        login("performance_glitch_user");
        logout();

    }

    @Test(priority = 5)
    public void errorUser() throws Exception {

        login("error_user");
        logout();

    }

    @Test(priority = 6)
    public void visualUser() throws Exception {

        login("visual_user");
        logout();

    }

    @AfterMethod
    public void closeBrowser() throws Exception {

        Thread.sleep(2000);

        driver.quit();

    }

}