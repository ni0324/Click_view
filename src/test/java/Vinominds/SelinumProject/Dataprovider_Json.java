package Vinominds.SelinumProject;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider_Json {

    WebDriver driver;

    String url = "https://www.saucedemo.com/";

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); 
        driver.get(url);
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        File file = new File(
                "src/test/java/Vinominds/SelinumProject/1Dataprovier_JSON.json"
        );

        JsonNode rootNode = mapper.readTree(file);

        JsonNode users = rootNode.get("loginUsers");

        Object[][] data = new Object[users.size()][2];

        for (int i = 0; i < users.size(); i++) {

            data[i][0] = users.get(i).get("username").asText();

            data[i][1] = users.get(i).get("password").asText();
        }

        return data;
    }

    @Test(dataProvider = "LoginData")
    public void ValidUsername_Password(String username, String password) {

        
        driver.get(url);

        
        driver.findElement(By.id("user-name"))
               .sendKeys(username);

        
        driver.findElement(By.id("password"))
               .sendKeys(password);

       
        driver.findElement(By.id("login-button"))
               .click();

        
        String title = driver.findElement(By.className("title"))
                            .getText();

        
        Assert.assertEquals(title, "Products");

        System.out.println(
                "Login Passed for Username: " + username
        );
    }

    @AfterClass
    public void QuitBrowser() {

        driver.quit();

        System.out.println("Browser Closed");
    }
}