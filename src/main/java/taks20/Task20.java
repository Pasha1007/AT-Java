package taks20;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task20 {
    private AppiumDriver driver;

    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:deviceName", "iPhone 16 Pro");
        capabilities.setCapability("appium:platformVersion", "18.1");
        capabilities.setCapability("appium:automationName", "XCUITest");
        capabilities.setCapability("appium:app", "/Users/pashakramar/Desktop/task20/build/Release-iphonesimulator/task20.app");
        capabilities.setCapability("appium:showXcodeLog", true);
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    public void testInputOutOfRange() throws IOException {
        WebElement inputField = driver.findElement(By.id("inputField"));
        WebElement submitButton = driver.findElement(By.id("submitButtonId"));

        inputField.sendKeys("99999999999999999999");
        submitButton.click();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), Path.of("screenshots/ios_out_of_range_test.png"));

        String pageSource = driver.getPageSource();
        Files.writeString(Path.of("screenshots/ios_dom_source.xml"), pageSource);

        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assert errorMessage.getText().contains("Value is out of range");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) throws Exception {
        Task20 test = new Task20();
        try {
            test.setup();
            test.testInputOutOfRange();
        } finally {
            test.tearDown();
        }
    }
}
