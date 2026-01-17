package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By pageTitle = By.className("title");
    private By firstProductAddToCartButton = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    private By cartIcon = By.className("shopping_cart_link");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addFirstProductToCart() {
        driver.findElement(firstProductAddToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public void logout() {
        driver.findElement(menuButton).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(logoutLink).click();
    }

	public String getURLOfProductPage() {
		return driver.getCurrentUrl();
	}
}