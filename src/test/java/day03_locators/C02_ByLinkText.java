package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByLinkText {
    public static void main(String[] args) throws InterruptedException {

        // 1- Bir test class'i oluşturun ilgili ayarları yapın
        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // 3- Sayffada 147 adet link bulunduğunu test edin.
        List<WebElement> linkListesi = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkListesi.size();

        if (expectedLinkSayisi == actualLinkSayisi) {
            System.out.println("Link sayisi testi PASSED");
        } else {
            System.out.println("Link sayisi testi FAILED");
        }

        // 4- Products linkine tıklayın
        // driver.findElement(By.linkText(" Products")).click();
        driver.findElement(By.partialLinkText("Products")).click(); // linkin bir parçası da kullabılabilir...

        // 5- special offer yazısının göründüğünü test edin
        WebElement speacialOfferElementi = driver.findElement(By.id("sale_image"));

        if (speacialOfferElementi.isDisplayed()){
            System.out.println("Special offer yazi testi PASSED");
        }else {
            System.out.println("Special offer yazi testi FAILED");
        }
        // 6- Sayfayı kapatın

        Thread.sleep(3000);
        driver.quit();

        // 1:50

    }
}
