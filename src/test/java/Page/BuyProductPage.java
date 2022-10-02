package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyProductPage extends BasePage{
    private By checkout= By.id("checkout");
    private By firstName=By.id("first-name");
    private By lastName=By.id("last-name");
    private By zip=By.id("postal-code");
    private By continueeButton=By.id("continue");

    public BuyProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getCheckout() {
        return getDriver().findElement(checkout);
    }

    public WebElement getFirstName() {
        return getDriver().findElement(firstName);
    }

    public WebElement getLastName() {
        return getDriver().findElement(lastName);
    }

    public WebElement getZip() {
        return getDriver().findElement(zip);
    }

    public WebElement getContinuee() {
        return getDriver().findElement(continueeButton);
    }
    public void checkoutButton()
    {
        getCheckout().click();
    }
    public void yourInformation(String firstName,String lastName, String zip)
    {
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getZip().sendKeys(zip);
        getContinuee().click();
    }
}
