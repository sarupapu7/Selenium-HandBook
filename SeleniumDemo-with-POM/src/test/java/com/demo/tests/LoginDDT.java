package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.base.BaseTest_POM;
import com.demo.pages.LoginPage_POM;

public class LoginDDT extends BaseTest_POM {

	// Step 1️⃣: Create DataProvider
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"student", "Password123", "Logged In Successfully"},   // valid case
            {"wrongUser", "Password123", "Your username is invalid!"}, // invalid username
            {"student", "wrongPass", "Your password is invalid!"}     // invalid password
        };
    }

    // Step 2️⃣: Create Test Method Using DataProvider
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedMessage) {

        // Create LoginPage object
        LoginPage_POM loginPage = new LoginPage_POM(driver);

        // Reuse the same login() method for every data set
        loginPage.login(username, password);

        // Step 3️⃣: Verify output (success or error message)
        String actualMessage = "";

        try {
            actualMessage = loginPage.getSuccessMessage();
        } catch (Exception e) {
            actualMessage = loginPage.getErrorMessage();
        }

        // Step 4️⃣: Assertion
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected message: " + expectedMessage + " | Actual: " + actualMessage);
    }
}
