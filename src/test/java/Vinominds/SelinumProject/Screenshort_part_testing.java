package Vinominds.SelinumProject;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshort_part_testing {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();

        WebDriver dr = new ChromeDriver();

        dr.manage().window().maximize();

        // Implicit Wait - 1 Minute
        dr.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        String[] users = {
                "standard_user",
                "locked_out_user",
                "problem_user",
                "performance_glitch_user",
                "error_user",
                "visual_user"
        };

        String password = "secret_sauce";

        for (String user : users) {

            dr.get("https://www.saucedemo.com/");

            // Login Page Screenshot
            takeScreenshot(dr, user + "_LoginPage");

            // Username
            dr.findElement(By.id("user-name")).sendKeys(user);

            // Password
            dr.findElement(By.id("password")).sendKeys(password);

            // Login
            dr.findElement(By.id("login-button")).click();

            Thread.sleep(5000);

            // Screenshot After Login
            takeScreenshot(dr, user + "_AfterLogin");
        }

        dr.quit();
    }

    public static void takeScreenshot(WebDriver driver, String name) throws IOException {

        // 12-Hour Time Format (AM/PM)
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss_a").format(new Date());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File("Screenshots/" + name + "_" + timeStamp + ".png");

        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot Saved : " + dest.getAbsolutePath());
    }
}