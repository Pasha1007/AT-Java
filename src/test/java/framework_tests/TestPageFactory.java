package framework_tests;

import framework.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPageFactory {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginAndAddProductToCart() {
        loginPage.openLogin();
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        loginPage.clickLogin();

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
