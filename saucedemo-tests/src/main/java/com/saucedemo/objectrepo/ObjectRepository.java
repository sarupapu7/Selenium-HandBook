package com.saucedemo.objectrepo;

import org.openqa.selenium.By;

/**
 * All locators centralized here.
 * Use By constants from pages/tests.
 */
public class ObjectRepository {

    // Login page
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_CONTAINER = By.cssSelector("h3[data-test='error']");

    // Home / Products page
    public static final By PRODUCTS_TITLE = By.className("title");
    public static final By SORT_DROPDOWN = By.className("product_sort_container");
    public static final By INVENTORY_ITEM_NAMES = By.cssSelector(".inventory_item_name");
    // Buttons for add/remove are specific per item, but this selects item buttons in the list:
    public static final By INVENTORY_ITEM_BUTTONS = By.cssSelector(".inventory_item button");
    public static final By CART_LINK = By.cssSelector(".shopping_cart_link");
    public static final By CART_BADGE = By.cssSelector(".shopping_cart_badge");

    // Cart page
    public static final By CART_ITEM_NAMES = By.cssSelector(".cart_item .inventory_item_name");
    public static final By CONTINUE_SHOPPING_BTN = By.id("continue-shopping");
    public static final By CHECKOUT_BTN = By.id("checkout");

    // Burger menu (left)
    public static final By MENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By MENU_LOGOUT = By.id("logout_sidebar_link"); // sometimes present
    public static final By MENU_ALL_ITEMS = By.cssSelector(".bm-item-list a");

    // Example footer / external links not always present; adjust if needed
    public static final By FOOTER_LINKS = By.tagName("a");
}
