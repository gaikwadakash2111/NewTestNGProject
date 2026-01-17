package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class YourCartTest extends BaseTest{
	
	@Test
	public void verifyContinueShoppingCTA() throws InterruptedException
	{
		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CartPage cartPage = new CartPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		productsPage.addFirstProductToCart();
		productsPage.goToCart();
		Thread.sleep(4000);
		Assert.assertTrue(cartPage.verifyContinuShoppingCTA());
	}
	
	@Test
	public void verifyContinueShoppingFunctionality() throws InterruptedException
	{
		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CartPage cartPage = new CartPage(driver);
		loginPage.login("standard_user", "secret_sauce");
		productsPage.addFirstProductToCart();
		productsPage.goToCart();
		Thread.sleep(4000);
		cartPage.clickOnContinueShopping();
		Thread.sleep(3000);
		Assert.assertEquals(productsPage.getURLOfProductPage(), "https://www.saucedemo.com/inventory.html");
		System.out.println("Continue Shopping CTA is working!!");
	}

}
