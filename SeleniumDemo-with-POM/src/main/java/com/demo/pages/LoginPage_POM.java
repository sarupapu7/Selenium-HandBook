package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_POM {

    WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("submit");
    private By successMsg = By.className("post-title");
    private By errorMsg = By.id("error");

    // Constructor
    public LoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions (Methods)
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    // Business method (full login)
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
