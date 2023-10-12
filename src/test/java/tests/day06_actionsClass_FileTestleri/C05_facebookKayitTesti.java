package tests.day06_actionsClass_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

import java.security.Key;

public class C05_facebookKayitTesti extends TestBase {
    @Test
    public void test01() throws InterruptedException {
       //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
       //2- Cookies kabul edin
       //3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@*='open-registration-form-button']")).click();
       //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement adınKutusu = driver.findElement(By.xpath("//*[@placeholder='Adın']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String emailAdresi = faker.internet().emailAddress();
        actions.click(adınKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(emailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(emailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("haz")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();
        Thread.sleep(7000);

        //5- Kaydol tusuna basalim
driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }

}
