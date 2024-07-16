package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ByClassName {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu ana sayfaya gidin

        // phone için arama yapın

        // arama sonucunda bulunan elementlerin, isimlerini yazdırın

        // arama sonucunda 4 ürün bulunabildiğini test edin

        // ilk ürün isminde phone geçtiğini test edin

        // sayfayı kapatın
        driver.close();


    }
}
