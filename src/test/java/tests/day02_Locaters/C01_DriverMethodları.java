package tests.day02_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DriverMethodları {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //ChromeDriver kullnarak,
        driver.get("https:facebook.com");
        // Facebook sayfasina gidin ve sayfa basliginin (title) "facebook" oldugunu dogrulayin (verify),degilse dogru basligi yazdirin
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";

        if (actualTitle.contains(expectedTitle)) System.out.println("başlıklar uyuşuyor, title test PASSED");
        else System.out.println("baslıklar uyusmuyor, title test FAİLED");
        // Sayfa url's,n,nn "facebook" keliesi icerdigini dogrulayin, icermiyorsa "actual" URL 'i yazdirin
        String expectedURLIcerik = "facebook";

        String actualUrl = driver.getCurrentUrl();
        if(actualTitle.contains(expectedURLIcerik)) System.out.println("expected url testi PASSED");
        System.out.println("Facebook sayfasinda Url facebook icermiyor, TEST FAİLED "+
                "\nActual URl : " + actualUrl);
        // walmart sayfasina gidin
        driver.navigate().to("https://www.walmart.com/");
        // sayfa basliginin walmart.com iceridgini dogrulayin
      String  expectedTitleIcerik = "Walmart.com";
        actualTitle  = driver.getTitle();
        if(actualTitle.contains(expectedTitleIcerik)) System.out.println("Walmart Title testi PASSED");
        else System.out.println("Walmart Title'i istenen icerigi barindirmiyor test FAİLED. " + "\nActual title: " + actualTitle);
        // tekrar"facebook" sayfasina donun
        driver.navigate().back();
        // sayfayi yenileyin
        driver.navigate().refresh();
        // sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        // browseri kapatin.
        driver.close();
        Thread.sleep(3000);
        driver.close();

    }
}
