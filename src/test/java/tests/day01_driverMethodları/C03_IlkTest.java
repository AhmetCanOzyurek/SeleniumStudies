package tests.day01_driverMethodları;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.sql.SQLOutput;

public class C03_IlkTest {
    public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            //3.amazon sayfasina gidelim
            driver.get("https://www.amazon.com");
            //4.sayfa basligini (title) yazdirin
            System.out.println("sayfa basligi : "+ driver.getTitle());

            //5 . sayfa basliginin "Amazon" icerdigini test edin

            String expectedIcerik = "Amazon";
            String actualTitle = driver.getTitle();
            if(actualTitle.contains(expectedIcerik)){
                System.out.println("Title testi PASSED");
            }else System.out.println("Title "+ expectedIcerik + "icermiyor, Test FAİLED");


            //6.Sayfa adresini (url) yazdirin
            System.out.println("Sayfa Url : " + driver.getCurrentUrl());

            //7. sayfa url'nin "amazon" icerdigini test edin.
            String expectedUrlIcerik = "amazon";
            String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Test PASSED");
        }else System.out.println("Test FAİLED");



        // 8. sayfa handle degerini yazdirin
        System.out.println("Sayfa handle degeri : "+ driver.getWindowHandle());
        //9. Sayfa HTML kodlarinda "alisveris" kelimesi gectigini test edin.

        String expectedHtmlIcerik = "alisveris";
        String actualPageSource = driver.getPageSource();

        if(actualPageSource.contains(expectedHtmlIcerik)) System.out.println("Test PASSED");
        else System.out.println("Sayfa kaynak kodlari "+ expectedHtmlIcerik+" icermiyor, Test FAİLED ");
            Thread.sleep(13000);
        driver.close();




    }
}
