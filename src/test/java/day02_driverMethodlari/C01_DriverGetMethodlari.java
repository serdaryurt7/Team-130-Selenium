package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testotomasyonu.com/");

        // Açılan sayfanın Title'ında otomasyon geçtiğini test edin

        String expectedTitleIcerik = "otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("Title testi PASSED");
        } else {
            System.out.println("Title 'otomasyon' icermiyor, title testi FAILED");
            System.out.println("Actual title : " + actualTitle);
        }


        // Açılan sayfanın URL'inin otomasyon içerdiğini test edin

        String expectedURL = "otomasyon";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)) {
            System.out.println("URL testi PASSED");
        } else {
            System.out.println("URL 'otomasyon' icermiyor, URL testi FAILED");
        }

        /*
            driver.getWindowHandle() : driver'in gittiği sayfanın Windowhandle değerini verir
            driver.getWindowHandles() : driver oluşturulduktan sonra, test boyunca
                                        açtığı tüm sayfaların WindowHandle değerlerini bir Set olarak verir

         */

        System.out.println(driver.getWindowHandle());
        // 763C5DC5437DAACD6689D23CDD223F7D
        System.out.println(driver.getWindowHandles());
        // [763C5DC5437DAACD6689D23CDD223F7D]

        System.out.println("========Sayfa Kaynagi ========");
        System.out.println(driver.getPageSource());
        // Tüm sayfa kaynağını döndürür, sayfa kaynağı ile ilgili bir test istenirse, kaydedilip kullanılabilir


        Thread.sleep(3000); // Java'dan gelir, kodları yazılan milisaniye kadar bekletir
        driver.close();

    }

}
