package tests.day08_Webtables_excellOtomasyonu_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;
import tests.utilities.ReusableMethods;

import java.util.List;
public class C01_Webtables extends TestBase {
    @Test
    public void webtable(){
      // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
      // 2. Headers da bulunan basliklari yazdirin
        List<WebElement>  headersList = driver.findElements(By.xpath("//*[@class='rt-tr']//*[@role='columnheader']"));
        int headersDataRow = 1;
        for (int i = 0; i < headersList.size(); i++) {
            System.out.println(headersDataRow+" - "+headersList.get(i).getText());
            headersDataRow++;
        }
        ReusableMethods.bekle(1);
        System.out.println("=====");
      // 3. 3.sutunun basligini yazdirin
        String ucuncuSutunBasligi = driver.findElement(By.xpath("//*[@class='rt-tr']//*[@role='columnheader'][3]")).getText();
        System.out.println("3.SUTUNUN basligi   :  "+ucuncuSutunBasligi);
      // 4. Tablodaki tum datalari yazdirin
        WebElement wholeTbody = driver.findElement(By.xpath("//*[@class='rt-tbody']"));
        System.out.println("tum body: " + wholeTbody.getText());
      // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> bosOlmayanCell  = driver.findElements(By.xpath("//*[@class='rt-tbody']//*[@class = 'rt-td']"));
        int sayac = 0;
        for (WebElement each:bosOlmayanCell
             ) {
            if(!each.getText().isBlank()) sayac++;
        }
        System.out.println("Body'deki bos olmayan dataCell sayisi: " +sayac );
      // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarrr = driver.findElements(By.xpath("//*[@role='rowgroup']"));
        System.out.println("Tablodaki satir sayisi : "+satirlarrr.size());
      // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("sutun sayisi : " + headersList.size());
      // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuColon = driver.findElements(By.xpath("//*[@role = 'rowgroup']//*[@class='rt-td'][3]"));
        for (WebElement each:ucuncuColon
        ) {
            if(!each.getText().isBlank()){
                System.out.println("3.sutun datalari : " + each.getText());
            }
        }
      // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        String maasXpath;
        String isimXpath;
        String isim;
        String maas;

        for (int i = 1; i < satirlarrr.size(); i++) {
            ////*[@role = 'rowgroup'][  3  ]//*[@class = 'rt-td'][  5  ]

            isimXpath = "//*[@role = 'rowgroup']["+i+"]//*[@class='rt-td'][1]";
            maasXpath = "//*[@role = 'rowgroup']["+i+" ]//*[@class='rt-td'][5]";

            isim = driver.findElement(By.xpath(isimXpath)).getText();
            maas = driver.findElement(By.xpath(maasXpath)).getText();

            if(isim.equals("Kierra")){
                System.out.println("Kierra'nın maası : " + maas);
            }
        }
      // 10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
       IstenenData(1,4);

    }
    public void IstenenData (int satirSayisi, int sutunSayisi){

        String dinamikXpath = "//*[@role = 'rowgroup']["+ satirSayisi+ "]//*[@class = 'rt-td']["+ sutunSayisi+"]";
        String istenenData = driver.findElement(By.xpath(dinamikXpath)).getText();
        System.out.println(satirSayisi+".ci satir, "+sutunSayisi+".ci sutundaki data: "+istenenData);
    }
}
