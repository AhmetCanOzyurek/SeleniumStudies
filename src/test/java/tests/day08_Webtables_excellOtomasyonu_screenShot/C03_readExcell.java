package tests.day08_Webtables_excellOtomasyonu_screenShot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_readExcell {
    @Test
    public void test01() throws IOException {
        // ayarlamalari yapip sayfa2'ye gidin
        String dosyaYolu = "src/test/java/tests/day08_Webtables_excellOtomasyonu_screenShot/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2"); // sayfa ismine dikkat etmek lazim.
        // Sayfada kullanilan son satir index'inin 23 oldugunu test edin
int expectedSonSatirIndeksi = 23;
int actualSonSatirIndexi = sayfa2.getLastRowNum();

        Assert.assertEquals(expectedSonSatirIndeksi,actualSonSatirIndexi);
        // sayfada aktif olarak kullanilan satir sayisinin 8 oldugunu test edin
int expectedActiveRowNum = 8;
int actualActiveRowNum =  sayfa2.getPhysicalNumberOfRows();

Assert.assertEquals(expectedActiveRowNum,actualActiveRowNum);

    }
}
