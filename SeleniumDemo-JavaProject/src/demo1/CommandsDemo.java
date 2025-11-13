package demo1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CommandsDemo {
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Browser commands
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        // Element commands
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("Password123");
        loginButton.click();

        // Get text message
        WebElement successMsg = driver.findElement(By.className("post-title"));
        System.out.println("Message: " + successMsg.getText());

        // Navigation commands
        driver.navigate().back();
        driver.navigate().refresh();

        driver.quit();
    }

}
