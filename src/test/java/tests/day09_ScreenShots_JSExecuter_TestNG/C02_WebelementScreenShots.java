package tests.day09_ScreenShots_JSExecuter_TestNG;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_WebelementScreenShots extends TestBase {
    @Test
    public void nutellaTesti() throws IOException {

//amazon anasayfasına gidin
        driver.get("https:amazon.com");
        // nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // sonuclarin nutella icerdigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));

        String expectedICerik = "Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        System.out.println(actualSonucYazisi);
        Assert.assertTrue(actualSonucYazisi.contains(expectedICerik));
        //rapora eklenmek uzere sonuc yazisinin fotografini cekin

        //1.adım : fotograftni cekmek istediginiz webelementi locate edin
        //        biz zaten sonuc yazi elementini locate etmistik


        //2. adim : fotografi kaydedecegimiz dosyayi olusturun

        File sonucYazisiFotografi = new File("target/ScreenShots/sonucYazisi.jpg");

        //3. adim : webelementi kullnarak screenshot olusutun ve
//                    gecici bir dosyaya kaydedin
        File geciciDosya = sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        //4.adim : gecici dosyayi asil dosyayi kopyalayalim

        FileUtils.copyFile(geciciDosya,sonucYazisiFotografi);
    }
}