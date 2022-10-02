package Page;
//Kreirati projekat i u njemu 2 paketa:
//pages
//tests
//Testirati rad sistema https://www.saucedemo.com
//Napraviti testove za sledece stranice:
//Login na stranicu (username: standard_user, password: secret_sauce)
//Dodavanje jednog proizvoda(po izboru) u korpu i provera da li je proizvod dodat
//Kupovina proizvoda (checkout)
//Konfirmacija kupovine (provera totala, konfirmacione poruke)
//Logout i provera otvaranja https://www.saucedemo.com/cart.html bez login-a
//U paketu pages dodati sve potrebne stranice.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

}
