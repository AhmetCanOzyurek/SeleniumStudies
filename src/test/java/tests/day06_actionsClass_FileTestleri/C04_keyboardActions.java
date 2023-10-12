package tests.day06_actionsClass_FileTestleri;

import net.bytebuddy.implementation.bytecode.ShiftLeft;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

import java.time.format.DateTimeFormatter;

public class C04_keyboardActions extends TestBase {

    @Test
    public void tset01(){
        //1- Bir Class olusturalim KeyboardActions1
//2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
//3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71" + Keys.ENTER).perform();
//4- aramanin gerceklestigini test edin
        WebElement sonucElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedIcerik = "Samsung A71";
        String actualIcerik = sonucElementi.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
}
