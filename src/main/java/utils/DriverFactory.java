package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {


        private static WebDriver driver;

        public static WebDriver getDriver() {
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hüseyin\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            return driver;
        }
    }

