package day01_driverOlusturma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {

    public static void main(String[] args) {

        /*
            1- Web otomasyonu yapmak için oluşturduğumuz her class'da
            bir WebDriver objesi oluşturmak ZORUNDAYIZ

            bu objeyi Java consept'lerini kullanarak, farklı şekillerde oluşturabilir  veya inherit edebiliriz
            AMMA WebDriver objesi OLMADAN test otomasyonu OLMAZ

            2- Selenium son versiyonlarında kendi WebDriver'ını oluşturdu
            Böylece System.SetProperty() kullanmasanız da, Selenium kendi WebDriver'i ile otomasyonu gerçekleştirir

            Şirketlerde kendi satın aldıkları WebDriver'i kullanma olasılığı olacağından, biz de bu satırı yazacağız

            3- WebDriver driver = new ChromeDriver();
            satırını yazdığımızda, bir WebDriver objesi oluşturulur
            bu obje sayesinde WebDriver methodlarini kullanabiliriz

         */

        System.setProperty("Webdriver.chrome.driver", "src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // driver.get("https://www.testotomasyonu.com");

    }

}
