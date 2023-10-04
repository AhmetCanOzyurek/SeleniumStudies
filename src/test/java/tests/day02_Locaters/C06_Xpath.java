package tests.day02_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- https://the_internet.herokuapp.com//add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2 - Add element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        //Delete butonunun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if(deleteButton.isDisplayed()) System.out.println("Delete butonu görünüyor.Test PASSED");
        else System.out.println("Delete butonu görünmüyor. Test FAİLED");
        //Delete tusuna basin
        deleteButton.click();
        // "Add/Remove Elements" yazisinin gorunur oldugunu test edin.
WebElement addRemoveElements = driver.findElement(By.xpath("//*[@id=\"content\"]/h3"));
if(addRemoveElements.isDisplayed()) System.out.println("Add/Remove Elements yazisi görünüyor. Test PASSED");
else System.out.println("Add/Remove Elements yazisi görünmüyor. Test FAİLED");


        Thread.sleep(3000);
        driver.close();

    }
}
