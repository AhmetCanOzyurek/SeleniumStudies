package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C01_actionClass extends TestBase {
    @Test
    public void test01() {
//    2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
       String firstWHD = driver.getWindowHandle();
//            3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement basılacakKutu = driver.findElement(By.id("hot-spot"));
        actions.contextClick(basılacakKutu).perform();
//4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedYazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
//5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
//6- Elemental Selenium linkine tiklayalim
      driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> WHDS = driver.getWindowHandles();
        String secondWHD = "";
        for (String each: WHDS
             ) {
            if(!firstWHD.equals(each)) secondWHD = each;
        }
        driver.switchTo().window(secondWHD);
//7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
String expectedHeader = "Make sure your code lands";
String actualHeader = driver.findElement(By.className("home-header")).getText();
Assert.assertEquals(expectedHeader,actualHeader);
    }
}