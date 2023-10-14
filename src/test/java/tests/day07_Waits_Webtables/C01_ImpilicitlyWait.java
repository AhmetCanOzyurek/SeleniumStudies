package tests.day07_Waits_Webtables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class C01_ImpilicitlyWait extends TestBase {
    @Test
    public void isEnabled(){
        //    2. Bir metod olusturun : isEnabled()
//3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.//*[text()='Enable']
driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//            4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
//5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
driver.findElement(By.xpath("//*[text()='Enable']")).click();

//6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
WebElement itsEnabled = driver.findElement(By.xpath("//p[@id='message']"));
Assert.assertTrue(itsEnabled.isDisplayed());
//7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(textBox.isEnabled());
    }

}
