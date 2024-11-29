package framework_tests;

import framework.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWebSingleton {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHomePageTitle() {
        driver.get("https://www.demoblaze.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "STORE", "Title should match!");
    }

    @AfterClass
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
