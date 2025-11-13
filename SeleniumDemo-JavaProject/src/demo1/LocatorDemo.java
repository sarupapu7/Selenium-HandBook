package demo1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Using ID locator
        driver.findElement(By.id("username")).sendKeys("student");
     
    //    Thread.sleep(2000);
        // Using Name locator
        driver.findElement(By.name("password")).sendKeys("Password123");

        // Using CSS Selector
        driver.findElement(By.cssSelector("#submit")).click();

        System.out.println("Login Successful!");
        driver.quit();
    }
}
