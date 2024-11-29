package framework_tests;

import framework.DriverPool;
import framework.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TestDriverHelper {
    private WebDriver driver;
    private DriverHelper helper;
    File destFile = new File("/Users/pashakramar/IdeaProjects/PracticeJava1/screenshots/screenshot.png");

    @BeforeMethod
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.manage().window().maximize();
        helper = new DriverHelper(driver);
    }

    @Test
    public void testLoginFunctionality() {
        driver.get("https://www.demoblaze.com/");
        helper.click(By.id("login2"));
        helper.typeText(By.id("loginusername"), "testUser");
        helper.typeText(By.id("loginpassword"), "testPassword");
        helper.captureScreenshot(String.valueOf(destFile));
        helper.click(By.xpath("//button[text()='Log in']"));

        Assert.assertTrue(helper.isElementVisible(By.id("logout2"), 10), "Login failed!");
    }

    @AfterMethod
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
