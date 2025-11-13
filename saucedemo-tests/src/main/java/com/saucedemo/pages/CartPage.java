package com.saucedemo.pages;

import com.saucedemo.objectrepo.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends ObjectRepository {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getCartItemNames() {
        List<WebElement> items = driver.findElements(CART_ITEM_NAMES);
        return items.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * Continue shopping (back to products)
     */
    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BTN).click();
    }

    public void checkout() {
        driver.findElement(CHECKOUT_BTN).click();
    }

    /**
     * Remove item by name (if present) using the Remove button associated with that item.
     * This implementation loops inventory items and clicks remove when names match.
     */
    public void removeItemByName(String productName) {
        List<WebElement> cartItems = driver.findElements(CART_ITEM_NAMES);
        for (WebElement item : cartItems) {
            if (productName.equals(item.getText().trim())) {
                // parent .cart_item has a button; use XPath relative to the item
                WebElement parent = item.findElement(By.xpath("./ancestor::div[contains(@class,'cart_item')]"));
                WebElement removeBtn = parent.findElement(By.cssSelector("button"));
                removeBtn.click();
                break;
            }
        }
    }
}
