package tests.day05_iFrame_JsAlert_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C05_İframe extends TestBase {
//   1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
//            2 ) Bir metod olusturun: iframeTest
//	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.


//            - Text Box’a “Merhaba Dunya!” yazin.
//	- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
    @Test
        public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement anİframeElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anİframeElementi.isEnabled());
        /*
        eger kullanmak istedigimiz WebElement bir iFrame'in icinde ise
        direkt kullanamayiz
        once iFrame'i locate edipi iFrame'e gecis yapmaliyiz

         */
        /*
        bir web sayfasının icinde bullunan iFrame'e gecis yaptiktan sonra
        yeniden ana sayfadan bir webelement kullanmak istersek

        once gecir yaptigimiz iFrame'den anasayfaya donmemiz gerekmektedir.
         */
        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

WebElement textBoxElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
textBoxElementi.clear();
textBoxElementi.sendKeys("Merhaba Dünya!");

driver.switchTo().defaultContent();//en üst sayfaya döner
        //driver.swichTo().parentFrame(); bir ust frame'e cıkar
WebElement elementalSeleniumElementi = driver.findElement(By.linkText("Elemental Selenium"));
Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());


    }



}
