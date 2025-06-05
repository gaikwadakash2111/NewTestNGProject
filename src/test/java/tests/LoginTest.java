package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Sorry"));
    }

    @Test
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        productsPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    }

    @Test
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addFirstProductToCart();
        productsPage.goToCart();
        Assert.assertNotNull(cartPage.getCartItemName());
    }

    @Test
    public void testCompleteCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addFirstProductToCart();
        productsPage.goToCart();
        cartPage.clickCheckout();
        checkoutPage.enterCheckoutInformation("John", "Doe", "12345");
        checkoutPage.finishCheckout();
        Assert.assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!");
    }
}