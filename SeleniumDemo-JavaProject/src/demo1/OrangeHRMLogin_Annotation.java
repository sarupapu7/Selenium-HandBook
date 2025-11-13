package demo1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class OrangeHRMLogin_Annotation {
	 WebDriver driver;

	    // --------------------------
	    // @BeforeMethod → Setup Code
	    // --------------------------
	    @BeforeMethod
	    public void setup() {
	        // Step 1: Launch browser
	        driver = new ChromeDriver();

	        // Step 2: Maximize window
	        driver.manage().window().maximize();

	        // Step 3: Open OrangeHRM website
	        driver.get("https://opensource-demo.orangehrmlive.com/");

	        System.out.println("Browser launched and OrangeHRM site opened.");
	    }

	    // --------------------------
	    // @Test → Actual Test Case
	    // --------------------------
	    @Test
	    public void loginTest() {
	        // Locate username field
	        WebElement username = driver.findElement(By.name("username"));
	        username.sendKeys("Admin");

	        // Locate password field
	        WebElement password = driver.findElement(By.name("password"));
	        password.sendKeys("admin123");

	        // Locate and click login button
	        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	        loginButton.click();

	        // Print title to verify login
	        String pageTitle = driver.getTitle();
	        System.out.println("Login Successful! Current Page Title: " + pageTitle);
	    }

	    // --------------------------
	    // @AfterMethod → Cleanup Code
	    // --------------------------
	    @AfterMethod
	    public void tearDown() {
	        // Step 1: Close browser
	        driver.quit();
	        System.out.println("Browser closed.");
	    }
}
