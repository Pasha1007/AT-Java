package framework.pages;

import org.openqa.selenium.WebDriver;

public class CartPageBO {
    CartPage cartPage;
    WebDriver driver;

    public CartPageBO(WebDriver driver) {
        this.driver = driver;
        cartPage = new CartPage(driver);
    }

    public void openCart() {
        cartPage.goToCart();
    }

    public int getProductCount() {
        return cartPage.getProductCount();
    }
}