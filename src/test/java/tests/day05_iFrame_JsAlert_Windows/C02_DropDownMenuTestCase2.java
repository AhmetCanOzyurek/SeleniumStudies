package tests.day05_iFrame_JsAlert_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;

public class C02_DropDownMenuTestCase2 extends TestBase {
    //1 http://zero.webappsecurity.com/ adresine gidin
    //Sing in butonuna basi
    // login ksımına username yazdin
    // password kısmında password yazin
    // signin tusuna basin pay bilss ayfasina gidin
    // purchase foreign currency tusuna basin
    // amount kutusuna bir sayi girin
    // US Dollars in secilmedigini tst edin
    // Selected currency butonunun seci
    // Calculate Costs butonuna basin sonra  purchase butonuna basimn
    // Foreign currency cash was succesfully puschased yazisininin ciktigini kontrol edin.

    @Test
    public void DDMTest(){
        driver.get("http://zero.webappsecurity.com/");
        //Sing in butonuna basi
        WebElement signInButton = driver.findElement(By.xpath("//*[@id='signin_button']"));
        signInButton.click();
        // login ksımına username yazdin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        // password kısmında password yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        // signin tusuna basin pay bilss ayfasina gidin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        // purchase foreign currency tusuna basin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        // amount kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("1453");
        // US Dollars in secilmedigini tst edin
        WebElement ddmMenu = driver.findElement(By.xpath("//select[@name='currency']"));
        Select select = new Select(ddmMenu);
        WebElement notUsDollar = driver.findElement(By.xpath("(//input[@name='inDollars'])[1]"));
        Assert.assertFalse(notUsDollar.isSelected());
        // Selected currency butonunun seci
        driver.findElement(By.xpath("(//input[@name='inDollars'])[2]")).click();
        select.selectByVisibleText("Japan (yen)");
        // Calculate Costs butonuna basin sonra  purchase butonuna basimn
        driver.findElement(By.xpath("//*[@value='Calculate Costs']")).click();
        driver.findElement(By.xpath("//*[@value='Purchase']")).click();
        // Foreign currency cash was succesfully puschased yazisininin ciktigini kontrol edin.
        WebElement foreignLogo = driver.findElement(By.xpath("//div[@id='alert_content']"));
        Assert.assertTrue(foreignLogo.isDisplayed());

    }
}
