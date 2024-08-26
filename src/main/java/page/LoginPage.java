package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

//    locators

    private By usernameField = By.name("life");
    private By paswordField = By.name("lifp");
    private By girisYapBtn = new By.ByXPath("//*[@id=\"lfb\"]");

    public  LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPasword(String pasword){
        driver.findElement(paswordField).sendKeys(pasword);

    }
    public void enterLogin(){
        driver.findElement(girisYapBtn).click();
    }
}
