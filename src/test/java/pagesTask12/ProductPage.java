package pagesTask12;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(), 'Add to cart')]")
    WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[1]/div")
    WebElement productName;
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[4]/a")
    WebElement cartLink;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    private void handlePasswordPopup() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            if (alert != null) {
                alert.dismiss();
            }
        } catch (Exception e) {
        }
    }

    public void addToCart() {
        handlePasswordPopup();
        wait.until(ExpectedConditions.visibilityOf(productName));
        productName.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        cartLink.click();
    }
}
