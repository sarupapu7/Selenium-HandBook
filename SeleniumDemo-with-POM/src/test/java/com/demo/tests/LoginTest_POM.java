package com.demo.tests;

import com.demo.base.BaseTest_POM;
import com.demo.pages.LoginPage_POM;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_POM extends BaseTest_POM {

    @Test
    public void validLoginTest() {
        LoginPage_POM loginPage = new LoginPage_POM(driver);
        loginPage.login("student", "Password123");

        String message = loginPage.getSuccessMessage();
        Assert.assertEquals(message, "Logged In Successfully", "Login message mismatch!");
    }

    @Test
    public void invalidLoginTest() {
        LoginPage_POM loginPage = new LoginPage_POM(driver);
        loginPage.login("wrongUser", "wrongPass");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Your username is invalid!"), "Error message mismatch!");
    }
}
