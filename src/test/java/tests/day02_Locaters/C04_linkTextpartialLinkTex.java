package tests.day02_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_linkTextpartialLinkTex {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        // gift cards linkine tıklayalim
        //driver.findElement(By.linkText("Don't Change")).click();

        driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();
      //  driver.findElement(By.linkText("Gift Cards")).click();

        //driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();

        // burada linkTExt STring olarak yazildigindan
        // Bosluklar ve buyuk kucuk harfr onemli olacaktir
        // linkText dendiginde HTML kodun icerisinde son kisimlarda acilis ve kapanis taglari
        // arasindaki metin tamamen yazilmalidir.<a> Gift Card</a>


        // eger tum metni degilde metnin bir parçasını kullanmak isterseniz partialLinkText)( metodunu kullanabilirsiniz.
        driver.findElement(By.partialLinkText("ards"));


       // driver.findElement(By.linkText(""))
        //Thread.sleep(5000);
        //driver.close();


    }

}
