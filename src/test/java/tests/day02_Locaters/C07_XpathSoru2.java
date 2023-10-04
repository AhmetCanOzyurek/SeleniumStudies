package tests.day02_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_XpathSoru2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2-  https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //3-  Browseri tam sayfa yapin
        driver.manage().window().fullscreen();
        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();
        driver.manage().window().maximize();
        //5-  Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedICerik = "Spend less";
        String actualIcerik = driver.getTitle();
        System.out.println(actualIcerik);
        if(actualIcerik.contains(expectedICerik)) System.out.println("Tıtle testi PASSED");
        else System.out.println("Title testi FAİLED");
        //6-  Gift Cards sekmesine basin
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();
        driver.findElement(By.linkText("Gift Cards")).click();
        //7-  Birthday butonuna basin
        driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[3]/span[1]")).click();
        driver.findElement(By.xpath("(//span[text()='Birthday'])[2]")).click();
        //driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[3]/span[1]")).click();


       // driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[2]/div[2]/div[1]/div/div[1]/ul/li[4]/a")).click();
        //8-  Best Seller bolumunden ilk urunu tiklayin
        //once bestseller bolumune tıklayın
        driver.findElement(By.xpath("(//span[@class='nav-a-content'])[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"B086KKT3RX\"]/a[1]/div/img")).click();

       // driver.findElement(By.xpath("driver.findElement(By.xpath(\"//*[@id=\\\"nav-subnav\\\"]/a[3]/span[1]\")).click();")).click();
        //9-  Gift card details’den diger kutusuna 30 yazdirin
        WebElement Prize = driver.findElement(By.xpath("//input[@placeholder='Other']"));


        //10-Urun ucretinin 30 oldugunu test edin
        Prize.sendKeys("30");
        System.out.println(Prize.getText());
      if(Prize.getText().equals("30")) System.out.println("30$ testi PASSED");
      else System.out.println("30$ testi FAİLED");
        //11-Sayfayi kapatin

        Thread.sleep(3000);
        driver.close();
    }
}
