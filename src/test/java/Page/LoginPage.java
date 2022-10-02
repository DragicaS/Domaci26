package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By username= By.id("user-name");
    private By password=By.id("password");
    private By loginButton=By.id("login-button");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getUsername()
    {
        return getDriver().findElement(username);
    }
    public WebElement getPassword()
    {
        return getDriver().findElement(password);
    }
    public WebElement getLoginButton()
    {
        return getDriver().findElement(loginButton);
    }
    public void login(String username, String password)
    {
        getUsername().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginButton().click();
    }
}
