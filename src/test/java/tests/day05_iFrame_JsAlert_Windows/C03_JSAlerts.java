package tests.day05_iFrame_JsAlert_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBaseClass;

public class C03_JSAlerts extends TestBaseClass {
//1. Test
//	-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
//            - 1.alert'e tiklayin
//            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
//            -  OK tusuna basip alert'i kapatin
//            2.Test
//	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
//            - 2.alert'e tiklayalim
//            - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
//            3.Test
//	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
//            - 3.alert'e tiklayalim
//            - Cikan prompt ekranina "Abdullah" yazdiralim
//	- OK tusuna basarak alert'i kapatalim
//            - Cikan sonuc yazisinin Abdullah icerdigini test edelim
    @Test
    public void Test01() throws InterruptedException {
//	-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
//            - 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
//            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedIcerik ="I am a JS Alert";
        String actualIcerik = driver.switchTo().alert().getText();
        Assert.assertEquals(actualIcerik,expectedIcerik);
//            -  OK tusuna basip alert'i kapatin
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
    @Test
    public void Test02() throws InterruptedException {
//	  - 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
//     - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        String sonucYazisi = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
        String expected = "You clicked: Cancel";
        Assert.assertEquals(sonucYazisi,expected);
    }
    @Test
    public void Test03() throws InterruptedException {
     //   - 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
//            - Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
//	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
//            - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expected = "Abdullah";
        Assert.assertTrue(sonucYazisi.contains(expected));
        WebElement cngrtElementi = driver.findElement(By.tagName("p"));

        Assert.assertTrue(cngrtElementi.isDisplayed());
    }


}
