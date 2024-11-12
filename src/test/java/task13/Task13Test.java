package task13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Task14Listener.class)
public class Task13Test {

    private WebDriver driver;

    @BeforeTest
    public void setUp(ITestContext context) {
        driver = new ChromeDriver();
        context.setAttribute("WebDriver", driver);
        driver.get("https://www.demoblaze.com/");
    }

    @Test
    public void testExample() {
        throw new AssertionError("Test failed for demonstration.");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
