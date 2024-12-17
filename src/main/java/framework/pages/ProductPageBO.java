package framework.pages;

import org.openqa.selenium.WebDriver;

public class ProductPageBO {
    ProductPage productPage;
    WebDriver driver;

    public ProductPageBO(WebDriver driver) {
        this.driver = driver;
        productPage = new ProductPage(driver);
    }

    public void addProductToCart(String productName) {
        productPage.selectProduct(productName);
        productPage.addToCart();
    }
}
