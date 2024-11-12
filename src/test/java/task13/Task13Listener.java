package task13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task13Listener implements ITestListener, ISuiteListener, IExecutionListener, IInvokedMethodListener {

    private static final Logger logger = LogManager.getLogger(Task13Listener.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test '{}' passed.", result.getName());
    }

    @Override
    public void onStart(ISuite suite) {
        logger.info("Suite '{}' is starting.", suite.getName());
    }

    @Override
    public void onExecutionFinish() {
        logger.info("Test execution is finished.");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test '{}' failed.", result.getName());

        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("WebDriver");

        if (driver != null) {
            saveScreenshot(driver, result);
            saveHtmlSource(driver, result);
        } else {
            logger.warn("WebDriver instance is null; could not capture screenshot or HTML source.");
        }
    }

    private void saveScreenshot(WebDriver driver, ITestResult result) {
        try {
            Path screenshotDir = Paths.get("screenshots");
            if (Files.notExists(screenshotDir)) {
                Files.createDirectories(screenshotDir);
            }

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), screenshotDir.resolve(result.getName() + ".png"));
            logger.info("Screenshot saved for '{}'.", result.getName());
        } catch (IOException e) {
            logger.error("Failed to save screenshot for '{}': {}", result.getName(), e.getMessage());
        }
    }

    private void saveHtmlSource(WebDriver driver, ITestResult result) {
        try {
            Path htmlDir = Paths.get("html_sources");
            if (Files.notExists(htmlDir)) {
                Files.createDirectories(htmlDir);
            }

            String pageSource = driver.getPageSource();
            assert pageSource != null;
            Files.write(htmlDir.resolve(result.getName() + ".html"), pageSource.getBytes());
            logger.info("HTML source saved for '{}'.", result.getName());
        } catch (IOException e) {
            logger.error("Failed to save HTML source for '{}': {}", result.getName(), e.getMessage());
        }
    }
}
