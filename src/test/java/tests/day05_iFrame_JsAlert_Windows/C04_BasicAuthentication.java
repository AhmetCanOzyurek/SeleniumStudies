package tests.day05_iFrame_JsAlert_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C04_BasicAuthentication extends TestBase {
    @Test
    public void test01(){
       // 1- Bir class olusturun : BasicAuthentication
       // 2- https://admin:admin@the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
       // 3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin

       // Html komutu : https://username:password@URL
       // Username     : admin
       // password      : admin
        WebElement cngrtElementi = driver.findElement(By.tagName("p"));

        Assert.assertTrue(cngrtElementi.isDisplayed());
       // 4- Basarili sekilde sayfaya girildigini dogrulayin
    }
}
