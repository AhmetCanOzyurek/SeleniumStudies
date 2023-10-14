package tests.day07_Waits_Webtables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWai {
@Test
    public void implicitlyWaitTesti(){
    //1. Test Base kullanmadan ayarlari yapin
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    //2. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    //3. Remove butonuna tıklayın ve it's gone! yazisi cikincaya kadar bekleyin
    driver.findElement(By.xpath("//*[text()='Remove']")).click();
    //4. “It’s gone!” mesajinin goruntulendigini dogrulayın.
    WebElement itsGone = driver.findElement(By.xpath("//p[@id='message']"));
    Assert.assertTrue(itsGone.isDisplayed());
    //5. Add butonuna tıklayın ve it's back! yazisi cikincaya kadar bekleyin
    driver.findElement(By.xpath("//*[text()='Add']")).click();
    //6. “It’s back!” mesajinin goruntulendigini dogrulayın.
    WebElement itsBack = driver.findElement(By.xpath("//p[@id='message']"));
    Assert.assertTrue(itsBack.isDisplayed());

}
@Test
    public void explicitlyWait(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
// 2 explicitliyWait ile asagidaki bekleme islemlerini gerceklestirin
// 2. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
  driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    //3. Remove butonuna tıklayın ve it's gone! yazisi cikincaya kadar bekleyin
    driver.findElement(By.xpath("//*[text()='Remove']")).click();
    //4. “It’s gone!” mesajinin goruntulendigini dogrulayın.
    WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(40));
    WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Remove']")));
    Assert.assertTrue(itsGoneElementi.isDisplayed());
    //5. Add butonuna tıklayın ve it's back! yazisi cikincaya kadar bekleyin

    WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add']")));
    add.click();
    WebElement itsBackElementi =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
    Assert.assertTrue(itsBackElementi.isDisplayed());
}

}
