package mobiletests.tests;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

import java.net.URL;
import java.time.Duration;

public class ValidationTests {
    private IOSDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 16 Pro")
                .setPlatformVersion("18.1")
                .setApp("/Users/pashakramar/Desktop/task20/build/Release-iphonesimulator/task20.app")
                .setNoReset(true);

        driver = new IOSDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
    }

    @Test
    public void testInputValidation() {
        By inputField = AppiumBy.accessibilityId("input_field");
        By submitButton = AppiumBy.accessibilityId("submit_button");
        By errorLabel = AppiumBy.accessibilityId("error_label");

        int invalidValue = 1_000_002;

        driver.findElement(inputField).sendKeys(String.valueOf(invalidValue));
        driver.findElement(submitButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String errorText = driver.findElement(errorLabel).getText();

        assert errorText.contains("exceeds maximum") :
                "Error message should indicate value out of range";
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}