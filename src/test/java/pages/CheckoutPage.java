package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(postalCodeInput).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }

    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}