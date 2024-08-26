package tests;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import page.TakipListem;
import utils.DriverFactory;

public class TakipListesiTest {

    private WebDriver driver;
    private TakipListem takipListem;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.getDriver();
        LoginTest loginTest = new LoginTest();
        loginTest.testLogin();
        takipListem = new TakipListem(driver);

    }

    @Test()
    public void takipListesiTests(){
        System.out.println("Takip Listesi Testleri");
        //step 1
        takipListem.searchProduct("iPhone 13");
        //step 2
        takipListem.takipYildizisigiPhones();
        //step 3
        takipListem.checkTakipEdilenProductNum();

    }


}
