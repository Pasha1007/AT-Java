package task12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pagesTask12.HomePage;
import pagesTask12.LoginPage;
import pagesTask12.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task12Test {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void testLoginAndAddProductToCart() {
        homePage.clickLogin();

        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        loginPage.clickLogin();

        productPage.addToCart();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
