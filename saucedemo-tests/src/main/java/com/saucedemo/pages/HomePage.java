package com.saucedemo.pages;

import com.saucedemo.objectrepo.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends ObjectRepository{

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return driver.findElement(PRODUCTS_TITLE).getText().trim();
    }

    public void sortBy(String visibleText) {
        WebElement dropdown = driver.findElement(SORT_DROPDOWN);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    public List<String> getAllProductNames() {
        List<WebElement> names = driver.findElements(INVENTORY_ITEM_NAMES);
        return names.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * Add the product at index (0-based) to cart.
     * Uses the list of buttons in the order of items rendered.
     */
    public void addProductToCartByIndex(int index) {
        List<WebElement> buttons = driver.findElements(INVENTORY_ITEM_BUTTONS);
        if (index >= 0 && index < buttons.size()) {
            buttons.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("No product button at index: " + index);
        }
    }

    /**
     * Convenience: add first product
     */
    public void addFirstProductToCart() {
        addProductToCartByIndex(0);
    }

    public String getProductNameByIndex(int index) {
        List<WebElement> names = driver.findElements(INVENTORY_ITEM_NAMES);
        if (index >= 0 && index < names.size()) {
            return names.get(index).getText().trim();
        }
        return null;
    }

    public void goToCart() {
        driver.findElement(CART_LINK).click();
    }

    public int getCartBadgeCount() {
        List<WebElement> badges = driver.findElements(CART_BADGE);
        if (badges.isEmpty()) {
            return 0;
        }
        String text = badges.get(0).getText().trim();
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void openBurgerMenu() throws InterruptedException {
        driver.findElement(MENU_BUTTON).click();
        // small sleep to allow animation (replace with explicit wait if needed)
        Thread.sleep(400);
    }

    public void logoutFromMenu() {
        driver.findElement(MENU_LOGOUT).click();
    }
}
