package task10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//1. Set up ChromeDriver using the driver file and properties.
//2. Set up ChromeDriver using DriverManager.
//3. Navigate to the page assigned to your variant.
//4. Select any three different elements.
//5. Interact with all the selected elements.
//6. Verify the visibility of each element using assertions.
//7. Wrap all these steps into a TestNG test case.

//V6. https://www.demoblaze.com/ (Log in)


public class Task10Manager {
     WebDriver driver;
     @BeforeTest
     void setUp() {
          ChromeDriverManager.getInstance().setup();
          driver = new ChromeDriver();
     driver.manage().window().maximize();
     }
     @Test
     void task10Test(){
          System.out.println("Test manager");
          driver.get("https://www.demoblaze.com/");
          WebElement loginMenuItem = driver.findElement(By.xpath("//*[@id=\"login2\"]"));
          loginMenuItem.click();
          WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"loginusername\"]"));
//          usernameField.click();
//          usernameField.sendKeys("admin");
          WebElement loginForm = driver.findElement(By.xpath("//*[@id=\"loginusername\"]/../../.."));
          loginForm.click();
     }
     @AfterTest
     void tearDown() {
          driver.quit();
     }
}
