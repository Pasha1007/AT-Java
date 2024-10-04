package task10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class Task10Test {
     WebDriver driver;
     @BeforeTest
     void setUp() {

          System.setProperty("webdriver.chrome.driver",
                  "Drivers/chromedriver");
          driver = new ChromeDriver();
     driver.manage().window().maximize();
     }
     @Test
     void task10Test(){
          driver.get("https://www.demoblaze.com/");
     }
}
