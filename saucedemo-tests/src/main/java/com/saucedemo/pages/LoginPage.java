package com.saucedemo.pages;

import com.saucedemo.objectrepo.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page object for the login page.
 * Actions only — locators are in ObjectRepository.
 */
public class LoginPage extends ObjectRepository{

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        WebElement user = driver.findElement(USERNAME_INPUT);
        user.clear();
        user.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement pass = driver.findElement(PASSWORD_INPUT);
        pass.clear();
        pass.sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    /**
     * convenience method to do full login
     */
    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
