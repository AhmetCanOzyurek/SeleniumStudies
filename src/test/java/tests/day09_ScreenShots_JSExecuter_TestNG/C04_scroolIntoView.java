package tests.day09_ScreenShots_JSExecuter_TestNG;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import tests.utilities.ReusableMethods;
import tests.utilities.TestBase;

public class C04_scroolIntoView extends TestBase {

    @Test
    public void test0(){
        //amazon anasayfaya gidin
        driver.get("https:amazon.com");
        //"Back to top " linki gorununceye kadar asagi inin
WebElement backToTop = driver.findElement(By.xpath("//*[@*='navFooterBackToTopText']"));
        ReusableMethods.bekle(1);
JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",backToTop);

        //back to top elementinin ss'ni alin
        ReusableMethods.webElementScreenShotcek(backToTop,"BackToTopSS");
        //Back to top' a tiklayıp sayfanın basına donun
       jse.executeScript("arguments[0].click();",backToTop);
        ReusableMethods.bekle(1);
        //tum sayfa ss'ni alin
        ReusableMethods.tumSayfaFotografCek(driver,"TumSayfaSS,BackToTop");
        jse.executeScript("alert('yasasinnn');");
    }
}
