package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import utils.DriverFactory;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    public void setUp(){
        driver = DriverFactory.getDriver();
        driver.get("https://www.akakce.com/akakcem/giris/");
        loginPage = new LoginPage(driver);
    }

    public  void testLogin(){
        setUp();
        loginPage.enterUsername("hmt14290152@gmail.com");
        loginPage.enterPasword("Hm9262023.");
        loginPage.enterLogin();

    }
}
