package tests.Day04_JunitFrameWork_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBox {
  // a. Verilen web sayfasına gidin.
  // https://the-internet.herokuapp.com/checkboxes

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
    public void checkBoxTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if(!checkBox1.isSelected()) checkBox1.click();
        Thread.sleep(2000);
        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if(!checkBox2.isSelected()) checkBox2.click();
        Thread.sleep(3000);
        // e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());


        //f. Checkbox1ve Checkbox2’nin tiklerini kaldırın
        checkBox2.click();
        checkBox1.click();
        Thread.sleep(3000);
        //g. Checkbox1ve Checkbox2’nin seçili olmadıgın test edin
        Assert.assertFalse(checkBox1.isSelected());
        Assert.assertFalse(checkBox2.isSelected());

    }

}
