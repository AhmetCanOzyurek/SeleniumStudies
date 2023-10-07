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

public class C04_YoutubeAssertions {
//   2) https://www.youtube.com adresine gidin
//           3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
//	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
//	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
//	○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//           ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    String  titleYoutube = driver.getTitle();
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com ");

    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void titleTest(){
        //○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        Assert.assertEquals(titleYoutube,expectedTitle);
    }
    @Test
    public void wrongTitle(){
        //    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectedTitle = "youtube";
        Assert.assertNotEquals(titleYoutube,unexpectedTitle);
    }
    @Test
    public void imageTest(){
      //  ○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageYt = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(imageYt.isDisplayed());
    }
    @Test
    public void searchBoxTest(){
        WebElement searcBox = driver.findElement(By.xpath("//*[@placeholder='Ara']"));
        Assert.assertTrue(searcBox.isEnabled());
    }
//	○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())


}
