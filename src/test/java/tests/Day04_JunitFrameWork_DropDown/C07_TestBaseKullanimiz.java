package tests.Day04_JunitFrameWork_DropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C07_TestBaseKullanimiz  extends TestBase{

    /*

    extends keyword
    icinde oldugumu C07 class'ini
    TestBase class'inin child class'i yapar
bu sayede C07 class'indan TestBase class'indaki
tum variable ve method'lari DIREKT kullanabiliriz
(static keyword'e dikkat etmek gerekir)
     */
@Test
    public void amazonTest(){

    // Amazon anasayfaya gidin
    driver.get("https:amazon.com");


    //Nutella icin arama yapin
    WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

    //Arama sonuclarinin Nutlella icerdigini test edin
WebElement nutellaArmasonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
String actualSonucYazisi = nutellaArmasonucu.getText();
String expectedIcerik = "nutella";
    Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
}
}
