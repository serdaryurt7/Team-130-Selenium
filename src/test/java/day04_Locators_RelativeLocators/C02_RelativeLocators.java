package day04_Locators_RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1) https://www.testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://www.testotomasyonu.com/relativeLocators");

        // 2) DSLR Camera'yi etrafındaki elementleri kullanarak, 3 farklı relative locator ile locate edip tıklayın

        // <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">

        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));

        // 3) Açılan ürünün DSLR Camera olduğunu test edin

        // 1. relative locate işlemi + click + test'i ayrı ayrı yapalım

        WebElement dslrCamera1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(appleKulaklik));
        dslrCamera1.click();

        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)) {
            System.out.println("1.Relative locator testi PASSED");
        } else System.out.println("1.Relative locator testi FAILED");

        Thread.sleep(3000);
        // 2. relative locate işlemi + click + test'i ayrı ayrı yapalım
        driver.get("https://www.testotomasyonu.com/relativeLocators");
        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));

        WebElement dslrCamera2 = driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelefon));

        dslrCamera2.click();

        expectedUrunIsmi = "DSLR Camera";
        urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)) {
            System.out.println("2.Relative locator testi PASSED");
        } else System.out.println("2.Relative locator testi FAILED");

        // 3. relative locate işlemi + click + test'i ayrı ayrı yapalım
        driver.get("https://www.testotomasyonu.com/relativeLocators");

        WebElement batKulaklik = driver.findElement(By.id("pic2_thumb"));

        WebElement dslrCamera3 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(batKulaklik));

        dslrCamera3.click();

        expectedUrunIsmi = "DSLR Camera";
        urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)) {
            System.out.println("3.Relative locator testi PASSED");
        } else System.out.println("3.Relative locator testi FAILED");


        Thread.sleep(3000);
        driver.quit();
    }
}
