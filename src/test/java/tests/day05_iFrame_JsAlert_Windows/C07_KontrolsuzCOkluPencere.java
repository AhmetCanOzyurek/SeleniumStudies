package tests.day05_iFrame_JsAlert_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;
import java.util.Set;
public class C07_KontrolsuzCOkluPencere extends TestBase{

// https://the-internet.herokuapp.com/windows adresine gidin.
//           ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//           ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//           ● Click Here butonuna basın.
//           ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//           ● Sayfadaki textin “New Window” olduğunu doğrulayın.
//           ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    @Test
    public void test1(){
// https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWhd = driver.getWindowHandle();
//           ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
String expectedIcerik = "Opening a new window";
String actualIcerik = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedIcerik,actualIcerik);
//           ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedIcerik2 = "The Internet";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedIcerik2,actualTitle2);
//           ● Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();
        Set<String> Whds = driver.getWindowHandles();
        String ikinciSayfaWhd = "";
        for (String each:Whds
             ) {
            if(!ilkSayfaWhd.equals(each)) ikinciSayfaWhd = each;
        }
        driver.switchTo().window(ikinciSayfaWhd);
//           ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
String  yeniTitle = driver.getTitle();
String expectedNewTitle = "New Window";
Assert.assertEquals(yeniTitle,expectedNewTitle);
//           ● Sayfadaki textin “New Window” olduğunu doğrulayın.
 String newText = driver.findElement(By.tagName("h3")).getText();
   Assert.assertEquals(newText,expectedNewTitle);
//           ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
driver.switchTo().window(ilkSayfaWhd);
        Assert.assertEquals(expectedIcerik2,actualTitle2);
    }
}
