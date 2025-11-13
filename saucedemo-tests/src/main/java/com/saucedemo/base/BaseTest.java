package com.saucedemo.base;

import com.saucedemo.utilities.ScreenshotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        // if test failed, take screenshot
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotUtil.captureScreenshot(driver, result.getName());
            System.out.println("📸 Screenshot saved: " + path);
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
