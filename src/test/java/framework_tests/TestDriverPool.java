package framework_tests;

import framework.DriverPool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDriverPool {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverPool.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testChrome() {
        driver.get("https://www.demoblaze.com/");
        Assert.assertEquals(driver.getTitle(), "STORE");
    }

    @AfterMethod
    public void tearDown() {
        DriverPool.quitDriver();
    }
}
