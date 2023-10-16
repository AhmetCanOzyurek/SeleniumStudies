package tests.day09_ScreenShots_JSExecuter_TestNG;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C03_WebelementSS extends TestBase {
    @Test
    public void test01() {


// amazon anasayfaya gidin
        driver.get("https:amazon.com");
// Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
// sonucların amazon icerdigini test edin ve sonuc yazisinin screenshot alin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));

        String expectedICerik = "Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        System.out.println(actualSonucYazisi);
        Assert.assertTrue(actualSonucYazisi.contains(expectedICerik));
        ReusableMethods.webElementScreenShotcek(sonucYaziElementi,"sonucYazisiSS");
// ilk urune tiklayin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"))
                .click();
// urun isminin Nutella icerdigini test edin ve urun isminin screenshotını alin
        WebElement urunIsimElementi= driver.findElement(By.xpath("//h1[@id='title']"));

        String expectedUrunIcerik = "Nutella";
        String actualUrunIsmi = urunIsimElementi.getText();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIcerik));
        ReusableMethods.webElementScreenShotcek(urunIsimElementi,"urunIsmiSS");
    }
}