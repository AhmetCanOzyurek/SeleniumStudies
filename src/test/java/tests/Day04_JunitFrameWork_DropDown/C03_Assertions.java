package tests.Day04_JunitFrameWork_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
  //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
  //        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
  //        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

  //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
static WebDriver driver;
  @BeforeClass
    public static  void setUp(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.get("https://www.bestbuy.com/ ");

  }
@AfterClass
    public static void tearDown() throws InterruptedException {
      Thread.sleep(1000);
      driver.close();
}

@Test
    public void urlTest(){
       //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    String currentUrl = driver.getCurrentUrl();
    String expectedUrl = "https://www.bestbuy.com/";
    Assert.assertEquals(currentUrl,expectedUrl);
}
@Test
    public void titleTesti(){
      // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    String unexpectedTitle = "Rest";
    String expectedTitle = driver.getTitle();
    Assert.assertFalse(expectedTitle.equals(unexpectedTitle));
}
@Test
    public void logoTesti(){
    //	○ logoTest => BestBuy logosunun görüntülendigini test edin
    WebElement logo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
    Assert.assertTrue(logo.isDisplayed());
}
@Test
    public void francisLinkTesti(){
    //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    WebElement francaisLogo = driver.findElement(By.xpath("//*[text()='Français']"));
    Assert.assertTrue(francaisLogo.isDisplayed());
}

}
