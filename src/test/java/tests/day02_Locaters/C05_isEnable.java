package tests.day02_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.WatchEvent;
import java.util.List;
import java.time.Duration;

public class C05_isEnable {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        // 3- sayfada 147 adet link bulundugunu test edin
        int expectedLinkSayisi = 147;
        List <WebElement> linklerinListesi = driver.findElements(By.tagName("a"));
        int actualLinkSayisi =linklerinListesi.size();
        if(expectedLinkSayisi == actualLinkSayisi) System.out.println("Link sayisi testi PASSED");
        else System.out.println("Link sayisi testi FAİLED\n" +
                "Sayfadaki link sayisi: " + actualLinkSayisi);
        // 4-products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();
        Thread.sleep(2000);

        // 5- special offer yazisinin gorundugunu test edin
        WebElement specialOffer = driver.findElement(By.id("sale_image"));
        if(specialOffer.isDisplayed()) System.out.println("Special offer elementi görünüypr TEST PASSED");
        else System.out.println("Special offer elementi görünmüyor TEST FAİLED");
        // 6 sayfayi kapatin,




        Thread.sleep(5000);
        //driver.close();
    }
}
