package demo1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationDemo {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
	
	// Step 1: Click on Start button
	driver.findElement(By.xpath("//div[@id='start']/button")).click();
	
//	// Step 2: Immediately try to read text
    WebElement msg = driver.findElement(By.id("finish"));
    System.out.println("Message is: " + msg.getText());  // ❌ Fails here
    
    
//  //Wait up to 10 seconds until the text is visible
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
//
//    System.out.println("Message is: " + msg.getText());  // ✅ Works perfectly


    driver.quit();

	}
}
