package tests.day06_actionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

public class C06_keyboardActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
      // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
      // 3- video’yu gorecek kadar asagi inin
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
      // 4- videoyu izlemek icin Play tusuna basin
        WebElement iframeVideo = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeVideo);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        // 5- videoyu calistirdiginizi test edinü
        Thread.sleep(1000);
        WebElement playButAfterPlay = driver.findElement(By.xpath("//*[@data-sessionlink='feature=player-button']"));
        Assert.assertTrue(playButAfterPlay.isDisplayed());
        Thread.sleep(1000);
    }
}
