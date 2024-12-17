package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    private By cartItems = By.cssSelector(".success");

    public void goToCart() {
        WebElement cartLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartur\"]")));
        cartLinkElement.click();
    }

    public int getProductCount() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }
}
