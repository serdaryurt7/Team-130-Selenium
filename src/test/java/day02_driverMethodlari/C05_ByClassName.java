package day02_driverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_ByClassName {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // aramaKutusu.submit();

        // arama sonucunda bulunan elementlerin, isimlerini yazdırın
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//a[@class='prod-title mb-3 ']"));
        /*
            Locate etmek için By.className method'u kullandığımızda
            HTML element'deki class attribute'unun değerinde space varsa
            By.className() çalışmayabilir
         */

        // liste WebElement'lerden oluştuğu için,
        // listeyi direk yazdırırsak, elementlerin referanslarını yazdırır

        for (WebElement each : bulunanUrunElementleriList
        ) {
            System.out.println(each.getText());
        }

        System.out.println(bulunanUrunElementleriList);

        // arama sonucunda 4 ürün bulunabildiğini test edin
        int expectedUrunSayisi = 4;
        int actualUrunSayisi = bulunanUrunElementleriList.size();

        if (expectedUrunSayisi == actualUrunSayisi) {
            System.out.println("Phone arama urun sayi testi PASSED");
        } else {
            System.out.println("Phone arama urun sayi testi FAILED");
        }

        // ilk ürün isminde case sensitive olmadan phone geçtiğini test edin

        String actualIlkUrunIsmi = bulunanUrunElementleriList.get(0).getText().toLowerCase();

        String expectedUrunIcerik = "phone";

        if (actualIlkUrunIsmi.contains(expectedUrunIcerik)){
            System.out.println("Ilk urun isim testi PASSED");
        }else {
            System.out.println("Ilk urun isim testi FAILED");
        }


        // sayfayı kapatın

        Thread.sleep(3000);

        driver.quit();


    }
}
