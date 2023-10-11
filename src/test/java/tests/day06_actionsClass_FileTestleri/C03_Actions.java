package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void test01(){
       // 1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
       // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement accountsButton = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountsButton).perform();
       // 3- “Create a list” butonuna basin
    driver.findElement(By.xpath("//*[text()='Create a List']")).click();
       // 4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String expectedHeader = "Your Lists";
        String actualIcerik = driver.findElement(By.xpath("//*[text()='Your Lists']")).getText();
        Assert.assertEquals(expectedHeader,actualIcerik);

    }
}
