package tests.day03_JUni;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_BeforeClass_AfterClass {
 static WebDriver driver;
    // 3 ayri test method'u olusturup, asagidaki 3 gorevi bu method'larda yapin
    // 1- amazon anasayfaya gidip title'in "Amazon" icerdigini test edin
    // 2- Nutella aratip, arama sonuclarinin "Nutella" icerdigini test edin
    // 3- Ilk urune tiklayin, ilk urun sayfasi acildiginda,
    //    urun isminin "Nutella" icerdigini test edin



    /*
    Eger class icinde calistiracagimiz test method'lari
    belirli adimlarla ilerliyorsa
    bir test method'unun calismasina bagli ise
    her method'dan sonra driver'i kapatip,
    sonraki method'da acmak MANTIKLI OLMAZ

    Bunun yerine testlerin sirali calismasini saglamak icin
    test01, test02... gibi isimler verip
    driver'in en basta olusturulmasi ve
    test method'larinin tamami calistirildiktan sonra   kapatilmasi ici
    @Before vee @After notasyonlari yerine
    @BeforeCLass ve @AfterClass notasyonlari kullanilir

    @BeforeClass ve @AfterClass notasyonlari kullanirken
    dikkat etmemiz gereken konu, bu notasyonlara sahip
    method'larin static olmasinin zorunlu olmasidir.
     */

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String expectedIcerik = "Amazon";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedIcerik)) System.out.println("Test PASSED");
        else{
            System.out.println("TEST FAİLED");
            throw new RuntimeException();
        }
    }
    @Test
    public void test02() throws InterruptedException {
        Thread.sleep(3000);
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id= 'twotabsearchtextbox']"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        String expectedIcerik = "nutella";
        String actual = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        if(actual.contains(expectedIcerik)) System.out.println("Nutella icerigi testi PASSED");
        else{
            System.out.println("Nutella Testi FAİLED");
            throw new RuntimeException();
        }
    }
@Test
    public void test03(){
       driver.findElement(By.xpath("(//*[@class='a-section a-spacing-base'])[1]")).click();
    String expectedIcerik = "Nutella";
    String actual = driver.findElement(By.xpath("//*[@id='productTitle']")).getText();
    if(actual.contains(expectedIcerik)) System.out.println("Nutella icerigi testi PASSED");
    else{
        System.out.println("Nutella Testi FAİLED");
        throw new RuntimeException();
    }
}
}
