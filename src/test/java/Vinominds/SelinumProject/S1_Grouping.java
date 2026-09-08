package Vinominds.SelinumProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class S1_Grouping {

    // alwaysRun = true ensures configuration methods execute even when groups are filtered in testng.xml
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test(groups = "smoke")
    public void loginTest() {
        System.out.println("Smoke - Login Test");
    }

    @Test(groups = "smoke")
    public void logoutTest() {
        System.out.println("Smoke - Logout Test");
    }

    @Test(groups = "sanity")
    public void searchTest() {
        System.out.println("Sanity - Search Test");
    }

    @Test(groups = "sanity")
    public void productTest() {
        System.out.println("Sanity - Product Test");
    }

    @Test(groups = "regression")
    public void paymentTest() {
        System.out.println("Regression - Payment Test");
    }

    @Test(groups = "regression")
    public void refundTest() {
        System.out.println("Regression - Refund Test");
    }
}