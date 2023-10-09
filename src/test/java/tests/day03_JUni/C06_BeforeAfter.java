package tests.day03_JUni;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforeAfter {
    WebDriver driver;
    // 3 test methodu olusturun
    // 3 method'da ayri ayri google, youtube ve amazon'a gidip
    // Title'larinda google, you tube ve amazon gectigini test edip
    // sayfayi kapatin
    /*
    Bir test calisirken
    Her test method'undan once calismasini istedigimiz ortaj kodlar varsa
    her method'da tekrar tekrar yazmak yerine
    @Before notasyonuna sahip ayri bir method ollarak yazabilirsiniz

        @Before notasyonuna sahip method'lar bagimsiz olarak CALİSTİRİLAMAZ
        bulunduklari class'da var olan tum @Test notasyonuna sahip method'lar
        calismaya baslamadan devreye girip ilgili ayarlari yaparlar.

        Bunun icin de isimleri genelde setUp olur

        @Before ve @After methodları sayesinde
        @Test methodlari daha anlasilabilir olur
        ve sadece testlere odaklanilir


        JUnit test'in passed veya failed olmasına
        test methodunun sorunsuz calisip calismadigina bakarak karar verir
        test method'u hicbir sorun olmadan execute edilirse test PASSED,

        method calisirken bir exception olusursa test FAİLED olur.

     */
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void googleTest(){
        driver.get("https:google.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "google";

        if (actualTitle.contains(expectedTitle)) System.out.println("Google Sign Test PASSED");
        else{
            System.out.println("Google sign Testi FAİLED");
            throw new RuntimeException();
        }
    }
    @Test
    public void youtubeTest(){
        driver.get("https:youtube.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";

        if (actualTitle.contains(expectedTitle)) System.out.println("youtube Sign Test PASSED");
        else {
            System.out.println("youtube sign Testi FAİLED");
            throw new RuntimeException();
        }

    }
    @Test
    public void amazonTest(){
        driver.get("https:amazon.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";

        if (actualTitle.contains(expectedTitle)) System.out.println("amazon Sign Test PASSED");
        else System.out.println("amazon sign Testi FAİLED");
    }

    /*
    ayni sekilde @Test notasyonuna sahip her method'dan sonra
    calismasini istedigimiz kodlar icin de
    @After notasyonuna  sahip teardown() olusturulur.
     */
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
