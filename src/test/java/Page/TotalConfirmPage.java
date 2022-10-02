package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TotalConfirmPage extends BasePage{
    private By finish= By.id("finish");

    public TotalConfirmPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFinish() {
        return getDriver().findElement(finish);
    }
    public void clickFinish()
    {
        getFinish().click();
    }
}
