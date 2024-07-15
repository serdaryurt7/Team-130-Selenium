package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://testotomasyonu.com");

        driver.navigate().to("https://www.youtube.com");
        // get(istenenUrl) ile aynı işlemi yapar

        // youtube anasayfaya gidin, title'ın "YouTube" içerdiğini test edin
        String expectedTitleIcerik = "YouTube";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(actualTitle)) {
            System.out.println("Youtube title testi PASSED");
        } else {
            System.out.println("Youtube title testi FAILED");
        }

        // tekrar testotomasyonu ana sayfaya dönün, sayfa kaynağının "Test Otomasyonu" içerdiğini test edin

        driver.navigate().back();
        String expectedSayfaIcerik = "Test Otomasyonu";
        String actualSayfakaynagi = driver.getPageSource();

        if (actualSayfakaynagi.contains(expectedSayfaIcerik)) {
            System.out.println("Test otomasyonu sayfa kaynagi testi PASSED");
        } else {
            System.out.println("Test otomasyonu sayfa kaynagi testi FAILED");
        }

        // bir daha youtube anasayfaya gidin, url'in https://www.youtube.com/ olduğunu test edin

        driver.navigate().forward();

        String expectedURL = "https://www.youtube.com/";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("Youtube URL testi PASSED");
        }else {
            System.out.println("Youtube URL testi FAILED");
        }


        Thread.sleep(3000);

        driver.close();
    }

}
