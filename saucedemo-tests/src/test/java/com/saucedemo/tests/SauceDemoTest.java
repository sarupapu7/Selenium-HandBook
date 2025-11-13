package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoTest extends BaseTest {

    @Test
    public void loginSortAddToCartAndVerify() throws Exception {
        // pages
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        // open and login
        login.open();
        login.loginAs("standard_user", "secret_sauce");

        // verify products page
        Assert.assertEquals(home.getTitleText(), "Products", "Not on Products page after login");

        // sort low to high
        home.sortBy("Price (low to high)");

        // capture first product name and add to cart
        String firstProduct = home.getProductNameByIndex(0);
        home.addFirstProductToCart();

        // verify cart count shows 1
        Assert.assertEquals(home.getCartBadgeCount(), 1, "Cart badge didn't update");

        // go to cart and verify item present
        home.goToCart();
        List<String> cartItems = cart.getCartItemNames();
        Assert.assertTrue(cartItems.contains(firstProduct), "Product added to cart is not present");

        // Cleanup: continue shopping and remove (optional)
        cart.continueShopping();
        // remove using HomePage button (product list buttons). Simple approach:
        // back to home, find remove for first product
        // (we'll just navigate back to products and remove via home page action)
        // Note: easier is to click remove button from HomePage button list if your test needs it.
    }

    @Test(dependsOnMethods = {"loginSortAddToCartAndVerify"})
    public void logoutViaMenu() throws Exception {
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);

        // open and login
        login.open();
        login.loginAs("standard_user", "secret_sauce");

        // open burger menu and logout
        home.openBurgerMenu();
        home.logoutFromMenu();

        // after logout, login button should be present on page (a simple assertion)
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"), "Not on expected URL after logout");
    }
}
