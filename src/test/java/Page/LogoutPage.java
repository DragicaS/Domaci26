package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage extends BasePage {
    private By menu=By.id("react-burger-menu-btn");
    private By logout=By.id("logout_sidebar_link");

    public LogoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getMenu()
    {
        return getDriver().findElement(menu);
    }
    public WebElement getLogout()
    {
        return getDriver().findElement(logout);
    }
    public void logoutCheck()
    {
        getMenu().click();
        getLogout().click();
        getDriver().get("https://www.saucedemo.com/cart.html");
    }
}
