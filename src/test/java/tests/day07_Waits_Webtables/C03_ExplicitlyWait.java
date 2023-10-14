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
import tests.utilities.TestBase;

import java.time.Duration;

public class C03_ExplicitlyWait {

        @Test
        public void isEnabled(){
            WebDriverManager.chromedriver().setup();
            WebDriver  driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));


            //    2. Bir metod olusturun : isEnabled()
//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.//*[text()='Enable']
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//            4. Textbox’in etkin olmadigini(enabled) dogrulayın
            WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
            driver.findElement(By.xpath("//*[text()='Enable']")).click();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
            wait.until(ExpectedConditions.elementToBeClickable(textBox));
            Assert.assertTrue(textBox.isEnabled());

//5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin


//6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
            WebElement itsEnabled = driver.findElement(By.xpath("//p[@id='message']"));
            Assert.assertTrue(itsEnabled.isDisplayed());
//7. Textbox’in etkin oldugunu(enabled) dogrulayın.
            Assert.assertTrue(textBox.isEnabled());



        }
}
