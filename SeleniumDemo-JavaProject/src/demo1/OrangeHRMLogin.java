package demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLogin {
    public static void main(String[] args) throws InterruptedException {
    	
        // Step 1: Tell Selenium where ChromeDriver is
    	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver-win64\\chromedriver.exe");
        // Step 2: Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Step 3: Open OrangeHRM login page
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Step 4: Interact with elements
        //Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();

        // Step 5: Print result
        Thread.sleep(3000);
        System.out.println("Page title after login: " + driver.getTitle());

        driver.quit();
    }
}
