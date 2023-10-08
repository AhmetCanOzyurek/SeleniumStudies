package tests.day05_iFrame_JsAlert_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;
import tests.utilities.TestBaseClass;

import java.util.List;

public class C01_DropDownMenu  extends TestBaseClass {
// https://www.amazon.com/ adresine gidin.
//           - Test 1
//   Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
//Test 2
//           1. Kategori menusunden Books secenegini  secin
//	2. Arama kutusuna Java yazin ve aratin
//	3. Bulunan sonuc sayisini yazdirin
//    	4. Sonucun Java kelimesini icerdigini test edin
    Select select;
@Test
public void DDMTest01() {

    WebElement menuElementi  = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
     select = new Select(menuElementi);

    int expectedKategoriSayisi = 45;
    List <WebElement>  optionsSayisi = select.getOptions();
    int actualKategoriSayisi =optionsSayisi.size();
    Assert.assertEquals(actualKategoriSayisi,expectedKategoriSayisi);
}
@Test
    public void DDMTest02(){

    WebElement menuElementi  = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
    select = new Select(menuElementi);
   // 1. Kategori menusunden Books secenegini  secin
    select.selectByVisibleText("Books");
    driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();
//	2. Arama kutusuna Java yazin ve aratin
WebElement aramaKutusu = driver.findElement(By.xpath("//*[@aria-label='Search Amazon']"));
aramaKutusu.sendKeys("Java"+Keys.ENTER);
//	3. Bulunan sonuc sayisini yazdirin
    String sonucSayisi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
    System.out.println(sonucSayisi);
// 4. Sonucun Java kelimesini icerdigini test edin
    String expectedIcerik = "Java";
Assert.assertTrue(sonucSayisi.contains(expectedIcerik));
}

}
