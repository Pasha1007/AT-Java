package framework_tests;

import framework_tests.pages.CartPageBO;
import framework_tests.pages.ProductPageBO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

import static org.testng.Assert.assertEquals;


    public class TestTC_BO_PO {
        private WebDriver driver;
        ProductPage productPage;
        CartPage cartPage;

        @BeforeClass
        public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.demoblaze.com/");

            productPage = new ProductPage(driver);
            cartPage = new CartPage(driver);
        }

        @Test
        public void shouldAddProductToCart() {
            ProductPageBO productPageBO = new ProductPageBO(driver);
            CartPageBO cartPageBO = new CartPageBO(driver);

            productPageBO.addProductToCart("Samsung galaxy s6");
            cartPageBO.openCart();

            int productCount = cartPageBO.getProductCount();
            assertEquals(productCount, 1, "Product was not added to the cart correctly.");
        }

        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }

}
