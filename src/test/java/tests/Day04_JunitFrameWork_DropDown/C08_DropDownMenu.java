package tests.Day04_JunitFrameWork_DropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;
import java.util.List;
public class C08_DropDownMenu extends TestBase {

    @Test
    public void Test01 (){
//https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
 //      1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //dropdown menude islem yapabilmek icin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption());
 //      2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption());
 //      3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption());


        //      4.Tüm dropdown değerleri(value) yazdırın
        System.out.println("=======");
        List <WebElement> optionsList  = select.getOptions();
        for (WebElement each:optionsList
             ) {
            System.out.println(each.getText());
        }
 //      5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedSize = 4;
        int actualSize = optionsList.size();

        Assert.assertEquals(expectedSize,actualSize);



    }
}
