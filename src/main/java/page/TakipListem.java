package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TakipListem {
    private WebDriver driver;

    private By searchArea = new By.ByXPath("//*[@id=\"q\"]");
    private By searchBtn = new By.ByXPath("//*[@id=\"H_s_v8\"]/button");
    private By elements = new By.ByXPath("//*[@id=\"APL\"]/li");
    private By takipListBtn = new By.ByXPath("//*[@id=\"H_f_v8\"]");
    private By takipListesiElements = new By.ByXPath("//*[@id=\"FL_v8\"]/li");

    private int yildizIsigiPhoneCount = 0;
    private int takipEdilenYildizIsigiPhoneNumber = 0;

    public TakipListem(WebDriver driver) {
        this.driver = driver;
    }



    public void searchProduct(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(searchArea));
        WebElement searchBox = driver.findElement(this.searchArea);
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.click();
        searchBox.sendKeys(product);
        driver.findElement(searchBtn).click();
        System.out.println("step 1: "+ isProductsListelendi());

    }
    public boolean isProductsListelendi(){
        List<WebElement> productList = driver.findElements(elements);
        return productList.size()>0;

    }

    public void takipYildizisigiPhones() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        List<WebElement> productList = driver.findElements(elements);
        for (WebElement element : productList) {
            if (element.findElement(By.tagName("a")).getAttribute("title").contains("iPhone 13 128 GB Yıldız Işığı")) {
                yildizIsigiPhoneCount++;
                WebElement addTakiplistesi = element.findElement(By.tagName("a"))
                        .findElement(By.tagName("span"))
                        .findElement(By.xpath(".//span[contains(@class, 'ufo_v8')]"));

                // Elementi görünecek şekilde sayfayı kaydırıyoruz
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addTakiplistesi);

                // Elementin tıklanabilir hale gelmesini bekliyoruz
                wait.until(ExpectedConditions.elementToBeClickable(addTakiplistesi));

                try {
                    // JavaScript ile tıklama yapmayı deniyoruz
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addTakiplistesi);
                    takipEdilenYildizIsigiPhoneNumber++;
                } catch (Exception ex) {
                    System.out.println("Element tıklanamadı: " + ex.getMessage());
                }

            }
        }
        System.out.println("step 2: "+ (yildizIsigiPhoneCount == takipEdilenYildizIsigiPhoneNumber) );
    }


    public void checkTakipEdilenProductNum() {
        int count = 0;
        driver.findElement(takipListBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(takipListesiElements));
        List<WebElement> elements = driver.findElements(takipListesiElements);
        for (WebElement element : elements) {
            if (!(element.findElement(By.tagName("a")).getAttribute("title").contains("iPhone 13 128 GB Yıldız Işığı"))) {
                count++;
            }
        }
        System.out.println("step 3: "+ (count==0));
    }
}
