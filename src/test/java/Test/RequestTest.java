package Test;

import Page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RequestTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private AddCheckProductPage addCheckProductPage;
    private BuyProductPage buyProductPage;
    private TotalConfirmPage totalConfirmPage;
    private LogoutPage logoutPage;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","D:\\Bootcamp\\chromedriver.exe");
        driver= new  ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver,wait);
        addCheckProductPage=new AddCheckProductPage(driver,wait);
        buyProductPage=new BuyProductPage(driver,wait);
        totalConfirmPage =new TotalConfirmPage(driver,wait);
        logoutPage=new LogoutPage(driver,wait);

    }
    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
    @Test(priority = 1)
    public void loginTest()
    {
        Assert.assertTrue(loginPage.getUsername().isDisplayed());
        Assert.assertTrue(loginPage.getPassword().isDisplayed());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        loginPage.login("standard_user","secret_sauce");
        String expectedResult="PRODUCTS";
        WebElement result= driver.findElement(By.className("title"));
        String actualResult= result.getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority = 2)
    public void add()
    {
        addCheckProductPage.clickAddToChart();
        String expectedResult="REMOVE";
        WebElement result= driver.findElement(By.id("remove-sauce-labs-backpack"));
        String actualResult=result.getText();
        Assert.assertEquals(actualResult,expectedResult);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addCheckProductPage.clickChart();
        String expectedResult2="1";
        WebElement result2= driver.findElement(By.className("cart_quantity"));
        String actualResult2=result2.getText();
        Assert.assertEquals(actualResult2,expectedResult2);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Test(priority = 3)
    public void buy()
    {
        Assert.assertTrue(buyProductPage.getCheckout().isDisplayed());
        buyProductPage.checkoutButton();
        String expectedResult="CHECKOUT: YOUR INFORMATION";
        WebElement result=driver.findElement(By.className("title"));
        String actualResult=result.getText();
        Assert.assertEquals(actualResult,expectedResult);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        buyProductPage.yourInformation("Marija","Maric","21000");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 4)
    public void confirmBuying()
    {
        Assert.assertTrue(totalConfirmPage.getFinish().isDisplayed());
        totalConfirmPage.clickFinish();
        String expectedResult="CHECKOUT: COMPLETE!";
        WebElement result= driver.findElement(By.className("title"));
        String actualResult=result.getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(priority = 5)
    public void logout()
    {

        logoutPage.logoutCheck();
        String expectedResult="Epic sadface: You can only access '/cart.html' when you are logged in.";
        WebElement result=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));

        String actualResult=result.getText();
        Assert.assertEquals(actualResult,expectedResult);



    }

}
