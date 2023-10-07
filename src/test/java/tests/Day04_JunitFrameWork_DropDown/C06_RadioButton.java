package tests.Day04_JunitFrameWork_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {

    WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
     @After
    public void tearDown() throws InterruptedException {
         Thread.sleep(3000);
         driver.close();
     }
     @Test
    public void radioButton(){
        // a. Verilen web sayfasına gidin.
         // https://facebook.com
         driver.get("https://facebook.com");
         // b. Cookies’i kabul edin

         // c. Create an account buton’una basin
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();
         // d. Radio button elementlerini locate edin ve size uygun olani secin
         driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
         // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
         WebElement kadinRadioButton =  driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
         WebElement ozelRadioButton =  driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
         Assert.assertFalse(kadinRadioButton.isSelected());
         Assert.assertFalse(ozelRadioButton.isSelected());
     }
}
