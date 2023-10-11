package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

import java.nio.file.WatchEvent;

public class C02_ActionsDemoQA extends TestBase {
    @Test
    public void DragMeAndDropHere (){
      //  1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
      //  2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragME = driver.findElement(By.xpath("//*[text()='Drag me']"));
        Actions actions = new Actions(driver);
        WebElement dropHere = driver.findElement(By.xpath("//*[text()='Drop here']"));
      actions.dragAndDrop(dragME,dropHere).perform();
      //  3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedIcerik = "Dropped!";
        String actualIcerik = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        Assert.assertEquals(expectedIcerik,actualIcerik);
    }
}
