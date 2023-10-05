package tests.day03_JUni;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;

public class C04_GoogleSeach {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
       // 3- cookies uyarisini kabul ederek kapatin
       // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedIcerik = "Google";
        String  actualIcerik = driver.getTitle();
        if(actualIcerik.contains(expectedIcerik)) System.out.println("Google sign Test PASSED");
        else System.out.println("Google sign  Test FAİLED");
       // 5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCıbıgı = driver.findElement(By.xpath("//*[@jsname='yZiJbe']"));
        aramaCıbıgı.sendKeys("Nutella"+ Keys.ENTER);//ikincisi
        //aramaCıbıgı.submit(); ilk enter'a basma secenegi
       // 6- Bulunan sonuc sayisini yazdirin
     WebElement sonucSayisiElementi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonucSayisiElementi.getText());
           String sonucYazisi = sonucSayisiElementi.getText();

           int ilkBoslukIndexi = sonucYazisi.indexOf(" ");
           int ikinciBoslukIndex = sonucYazisi.indexOf(" ",ilkBoslukIndexi+1);

        String  sonucSayiStr = sonucYazisi
                                .substring(ilkBoslukIndexi,ikinciBoslukIndex)
                                        .replaceAll("\\D","");//15000000
        System.out.println(sonucSayiStr);

            int sonucSayisi = Integer.parseInt(sonucSayiStr);

        // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
            if (sonucSayisi>10000000) System.out.println("sonuc sayisi testi PASSED");
            else System.out.println("sonuc sayisi testi PASSED");

            /*
             WebElement sonucElementi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucElementi.getText());
        // About 150.000.000 results (0,30 seconds)

        String sonucYazisi = sonucElementi.getText();
        int ilkBoslukIndexi= sonucYazisi.indexOf(" ");
        int ikinciBoslukIndexi = sonucYazisi.indexOf(" ", ilkBoslukIndexi+1);

        String sonucSayiStr = sonucYazisi
                            .substring(ilkBoslukIndexi,ikinciBoslukIndexi)
                            .replaceAll("\\D",""); // "150000000"

        int sonucSayisi = Integer.parseInt(sonucSayiStr);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        if (sonucSayisi>10000000){
            System.out.println("Sonuc sayisi testi PASSED");
        }else{
            System.out.println("Sonuc sayisi testi FAILED");
        }
             */
       // 8- Sayfayi kapatin

        Thread.sleep(3000);
        driver.close();
    }
}
