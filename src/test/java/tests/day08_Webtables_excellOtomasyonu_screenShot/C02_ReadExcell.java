package tests.day08_Webtables_excellOtomasyonu_screenShot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import tests.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcell extends TestBase {

Sheet sayfa1;

    @Test
    public void excellTesti() throws IOException {
        String dosyaYolu = "src/test/java/tests/day08_Webtables_excellOtomasyonu_screenShot/ulkeler.xlsx";
        FileInputStream fileInputStrem = new FileInputStream(dosyaYolu);//java
        Workbook workbook = WorkbookFactory.create(fileInputStrem);// apache.poi
//- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        sayfa1 = workbook.getSheet("Sayfa1");
        Row row = sayfa1.getRow(0);
        Cell cell = row.getCell(1);
        System.out.println(cell);
//- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String ıstenenHucre = sayfa1.getRow(0).getCell(1).toString();
        System.out.println("String olarak istenen hucre : "+ıstenenHucre);
//- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedBaskent = "Kabil";
        String actualBAskent = sayfa1.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedBaskent,actualBAskent);
// Satir sayisini bulalim
        int satirSayisi = sayfa1.getLastRowNum()+1;// sonsatırın indeksi artı bir bize actual satir sayisini verir. getLastRow() + 1 gives us actual row number.
        System.out.println("excell'deki satir sayisi:  " + satirSayisi);
//- Fiziki olarak kullanilan satir sayisini bulun
        int kullamilanSatirSayisi = sayfa1.getPhysicalNumberOfRows();
        System.out.println("Aktif olarak kullanilan satir sayisi: " + kullamilanSatirSayisi);

        // sayfada turkce baskent olarak bern bulundugunu test edin
        boolean bernVarmı = false;
        String turkceBaskentIsmi;
        for (int i = 0; i < satirSayisi ; i++) {
        turkceBaskentIsmi = sayfa1.getRow(i).getCell(3).toString();
            if(turkceBaskentIsmi.equals("Bern")) {
            bernVarmı = true;
            break;
            }
        }
        Assert.assertTrue(bernVarmı);

        // bir method olusturun, istedigim satir ve sutun numarasina sahio
        // cell'deki yaziyi yazdirsin.

        hucreYazdir(15,2);
    }

    public void hucreYazdir(int satirNo, int sutunNO){
        String istenenHucreYazisi = sayfa1.getRow(satirNo-1).getCell(sutunNO-1).toString();//indeks numarasi dondurdugunden dolayi -1 yazdik
        System.out.println(satirNo + ". satir " + sutunNO + ". sutun nolu bilgi: " +istenenHucreYazisi );
    }
}