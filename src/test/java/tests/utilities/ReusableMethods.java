package tests.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public static void tumSayfaFotografCek(WebDriver driver,String screenShotIsmi){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        //doya adini dinamik  yapalim
        //target/ScreenShots/TumSayfaSS.png"
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat= DateTimeFormatter.ofPattern("yyMMddHHmm");
        localDateTime.format(istenenFormat);//ilkUrun2310080829
        String dinamikDosyaAdi = "target/ScreenShots/"+screenShotIsmi
                +localDateTime.format(istenenFormat)+".jpg";

        File tumSayfaSS  = new File(dinamikDosyaAdi);
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        screenshot dosyasi icin hep ayni ismi kullanirsak
        tum cekilen fotograflar ayni isimle kaydedileceginden
        tek bir dosya olur, son cekilen fotograf eskilerin uzerine kaydolur


        cektigimiz fotograflarin hepsinin kalmasi
        ve istenilen isimde olmasi icin dosya adini dinamik yapalim

        1- method'un cagrildigi yerde bir fotograf ismi yazilsin
        2- method'da dosya ismine tarih etiketi ekleyelim
        ilkUrun2310080829
         */
    }
    public static void webElementScreenShotcek(WebElement istenenWEbElement, String screenShotIsmi){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat= DateTimeFormatter.ofPattern("yyMMddHHmm");
        localDateTime.format(istenenFormat);//ilkUrun2310080829
        String dinamikDosyaAdi = "target/ScreenShots/"+screenShotIsmi
                +localDateTime.format(istenenFormat)+".jpg";
        File webelementSS = new File(dinamikDosyaAdi);
        File geciciDosya = istenenWEbElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,webelementSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
