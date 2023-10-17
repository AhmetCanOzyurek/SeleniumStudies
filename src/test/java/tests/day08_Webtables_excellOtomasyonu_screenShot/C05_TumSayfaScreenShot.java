package tests.day08_Webtables_excellOtomasyonu_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import tests.utilities.TestBase;
import tests.utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class C05_TumSayfaScreenShot extends TestBase {
    @Test
    public void nutellaTesti() throws IOException {

//amazon anasayfasına gidin
driver.get("https:amazon.com");
        // nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // sonuclarin nutella icerdigini test edin
WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));

String expectedICerik = "Nutella";
String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedICerik));
        // rapora eklenmek uzere tum sayfanın fotosunu cekin
        //1.adim obje olustur ve driver'i deger olarak ata
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;


        //2. adim fotografi kaydedecegimiz dosyayi hazirlayalim
        // bunun icin olusturacagimiz dosyanin dosya yolunu hazirlamaliyiz

        File tumsayfaFotograf = new File("target/ScreenShots/tumSayfaSS.png");

        //2. takesScreenShot objesinin kullnarak fotografi cekin
        // ve ileride kullanilmak uzere gecici bir dosyaya kaydedin

        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        //4. gecici dosyayi, remsi kaydetmek uzere hazirladigimiz dosyay kopyalayalim
        FileUtils.copyFile(geciciDosya,tumsayfaFotograf);

        ReusableMethods.bekle(2);
    }
}
