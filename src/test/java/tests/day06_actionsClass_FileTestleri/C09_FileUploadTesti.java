package tests.day06_actionsClass_FileTestleri;

import org.junit.Test;
import tests.utilities.TestBase;

public class C09_FileUploadTesti extends TestBase{

        @Test
        public void fileUploadTEsti() throws InterruptedException {
            //https://the-internet.herokuapp.com/upload adresine gidelim
            driver.get("https://the-internet.herokuapp.com/upload ");
            //chooseFile butonuna basalim
            System.out.println(System.getProperty("user.home"));
            //  //bilgisayardaki kullanici ana dosyanin dosya yolu : /Users/enesoncu
            System.out.println(System.getProperty("user.dir"));
            //Users/enesoncu/IdeaProjects/com.unityverse_Selenium
            //Users/enesoncu/IdeaProjects/com.unityverse_Selenium/src/test/java/tests/deneme.txt ------> absolute path
            // //tests/deneme.txt
            String dinamikDosyaYolu = System.getProperty("user.dir")+"/src/test/java/tests/deneme.txt";
            // //Yuklemek istediginiz dosyayi secelim.
            //  WebElement fileUploadButonu = driver.findElement(By.id("file-upload"));
            //  fileUploadButonu.sendKeys(dinamikDosyaYolu);
            // //Upload butonuna basalim.
            //  driver.findElement(By.id("file-submit")).click();
            // //“File Uploaded!” textinin goruntulendigini test edelim.
            //  WebElement fileUpload = driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
            //  Assert.assertTrue(fileUpload.isDisplayed());
//
            Thread.sleep(8000);
        }
    }




