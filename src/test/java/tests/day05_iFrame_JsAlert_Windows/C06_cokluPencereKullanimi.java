package tests.day05_iFrame_JsAlert_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import tests.utilities.TestBase;

public class C06_cokluPencereKullanimi  extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https:amazon.com");
        String ilkSayfaWhd = driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());//71C8F24C68E5E10F25D6300BC7D14567
        System.out.println(driver.getWindowHandles());//[71C8F24C68E5E10F25D6300BC7D14567]

        // yeni bir tab acarak youtube gidelim

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.get("https:youtube.com");
String ikinciSayfaWhd = driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());//F385CE231D827554A3B33D0FFD834684
        System.out.println(driver.getWindowHandles());//[2575ACA06120BBAB201C3B64A673729C, F385CE231D827554A3B33D0FFD834684]
        Thread.sleep(3000);



        // yeni bir tab acarak arabam.com gidelim
        driver.switchTo().newWindow(WindowType.TAB).get("https:arabam.com");
        String ucuncuSayfaWhd = driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());//[C918224F943E2B6586DD0744F197CDB2, CEF84E51765E7C871050ACDDB160C852, 00D051A5B2C0530C99B48D42CFAC3E92]
        Thread.sleep(3000);




        //amazonun acik oldgugu sayfaya gidin
        //ve title'in amazon oldugunu test edin
        // an itibariyle driverimiz arabam.com oldugu sayfada
        //gecis icin amazon'un acik oldugu sayfanin window handle degerine ihtiyacimiz var
        driver.switchTo().window(ilkSayfaWhd);
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //youtube'in  acşk oldugu sayfaya gidin
        // ve url'in youtube icerdigini test edin
        driver.switchTo().window(ikinciSayfaWhd);
        String expectedUrl = "youtube";
        String actualurl = driver.getCurrentUrl();
        Assert.assertTrue(actualurl.contains(expectedUrl));
        //arabam.com'un acik oldugu sayfaya gidin
        // ve logonun gorundugunu test edin
        driver.switchTo().window(ucuncuSayfaWhd);
        driver.findElement(By.xpath("//*[text()='Kabul Et']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@alt='arabam.com']")).isDisplayed());

    }
}
