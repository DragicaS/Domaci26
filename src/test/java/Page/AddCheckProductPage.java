package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddCheckProductPage extends BasePage {
    private By addToChart=By.id("add-to-cart-sauce-labs-backpack");
    private By checkChart=By.id("shopping_cart_container");

    public AddCheckProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAddToChart() {
        return getDriver().findElement(addToChart);
    }


    public WebElement getCheckChart() {
        return getDriver().findElement(checkChart);
    }
    public void clickAddToChart()
    {
        getAddToChart().click();
    }
    public  void clickChart()
    {
        getCheckChart().click();
    }


}
