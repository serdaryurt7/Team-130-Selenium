package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        // 1- Bir test class'i oluşturun ilgili ayarları yapın
        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.testotomasyonu.com/ adresine gidin

        driver.get("https://www.testotomasyonu.com");
        // 3- arama kutusuna phone yazıp aratın

        // WebElement searchBox = driver.findElement(By.id("global-search"));
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("phone", Keys.ENTER);

        // 4- Category bolumunde 8 element olduğunu test edin

        List<WebElement> categoryElementleriList = driver.findElements(By.className("panel-list"));
        int expectedCategorySayisi = 8;
        int actualCategorySayisi = categoryElementleriList.size();

        if (actualCategorySayisi == expectedCategorySayisi) {
            System.out.println("Category sayisi testi PASSED");
        } else {
            System.out.println("Category sayisi testi FAILED");
        }

        // 5- Category isimlerini yazdırın

        for (WebElement each : categoryElementleriList
        ) {
            System.out.println(each.getText());
        }

        // 6- Sayfayı kapatın

        Thread.sleep(3000);
        driver.quit();


        /*
            Classname web elementleri bir liste olarak alıp, onları bir liste olarak yönetmek için kullanılır
                     riskleri vardır. Classname de space var ise bu method çalışmayabilir
         */

    }

}
