package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_XPath_textKullanimi {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://www.testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://www.testotomasyonu.com/addremove/");

        //2- Add element butonuna basin
        // driver.findElement(By.id("sub-btn")).click();
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //3- Remove butonu'nun görünür olduğunu test edin
        // WebElement removeButonu = driver.findElement(By.className("remove-btn"));
        WebElement removeButonu = driver.findElement(By.xpath("//*[text()='Remove']"));

        if (removeButonu.isDisplayed()) {
            System.out.println("Remove butonu gorunme testi PASSED");
        } else {
            System.out.println("Remove butonu gorunme testi FAILED");
        }

        //4- Remove tuşuna basın
        removeButonu.click();

        //5- "Add/Remove Elements" yazısının görünür olduğunu test edin

        // WebElement addRemoveYaziElementi = driver.findElement(By.tagName("h2"));
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveYaziElementi.isDisplayed()) {
            System.out.println("Add/Remove Gorunme Testi PASSED");
        } else {
            System.out.println("Add/Remove Gorunme Elementi Testi FAILED");
        }

        driver.quit();

    }
}
