package com.demo.pages;

//imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
 WebDriver driver;
 WebDriverWait wait;

 By username = By.name("username"); // update if your locator differs
 By password = By.name("password");
 By loginBtn  = By.cssSelector("button[type='submit']"); // or correct selector

 public LoginPage(WebDriver driver) {
     this.driver = driver;
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 }

 public void login(String user, String pass) {
     // wait for username to be visible
     WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
     userField.clear();
     userField.sendKeys(user);

     WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
     passField.clear();
     passField.sendKeys(pass);

     WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
     btn.click();
 }
}
