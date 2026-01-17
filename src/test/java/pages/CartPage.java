package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By cartItemName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");
    private By continueShoppingCTA = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

	public boolean verifyContinuShoppingCTA() {
		return driver.findElement(continueShoppingCTA).isDisplayed();
	}
    
    public void clickOnContinueShopping()
    {
    	driver.findElement(continueShoppingCTA).click();
    }

	public String verifyPresenceOfYourCartPage() {
		return driver.getTitle();
	}
}