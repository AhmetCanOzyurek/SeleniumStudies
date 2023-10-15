package tests.day07_Waits_Webtables;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;
import java.util.List;
import java.nio.file.WatchEvent;

public class C05_WebTables  extends TestBase {

    @Test
    public void amazonWebTableTesti() throws InterruptedException {
      //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
      //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
      Thread.sleep(1000);
        //3.Web table tum body’sini yazdirin
        WebElement wholeTableBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(wholeTableBody.getText());
        //4.Web table’daki satir sayisinin 7 oldugunu test edin
        List<WebElement> satirElementleriListesi = driver.findElements(By.xpath("//tbody/tr"));
        int expectedRow = 7;
        int actualRow = satirElementleriListesi.size();
        Assert.assertEquals(actualRow,expectedRow);
      //5.Tum satirlari yazdirin
        System.out.println("=============");
        for (int i = 0; i <satirElementleriListesi.size() ; i++) {
            System.out.println(i+1 + ".satir    :    " + satirElementleriListesi.get(i).getText());
        }
      //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> birinciSatirDatalarListesi = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedColon = 13;
        int actualColon = birinciSatirDatalarListesi.size();
        Assert.assertEquals(expectedColon,actualColon);
      //7. 5.sutunu yazdirin
        List<WebElement> ColonListesi5colon = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("============5.Sutun==========");
        for (WebElement each:
                ColonListesi5colon) {
            System.out.println(each.getText());
        }
      //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(hucredekiBilgi(1,2));
    }
    public String hucredekiBilgi(int satirSayisi, int sutunSayisi){
        String dinamikXPath = "//tbody/tr["+satirSayisi+"]/td["+sutunSayisi+"]";
        WebElement satirSutunSayisi = driver.findElement(By.xpath(dinamikXPath));
        return satirSutunSayisi.getText();
    }
}
