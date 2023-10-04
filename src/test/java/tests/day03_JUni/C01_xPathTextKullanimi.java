package tests.day03_JUni;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_xPathTextKullanimi {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- https://the_internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2 - Add element butonuna basin
        WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElement.click();
        //Delete butonunun gorunur oldugunu test edin
        Thread.sleep(3000);
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        if(deleteButton.isDisplayed()) System.out.println("Delete button visible. Test PASSED");
        else System.out.println("Delete button invisible.Test FAİLED");
        //Delete tusuna basin
        deleteButton.click();
        // "Add/Remove Elements" yazisinin gorunur oldugunu test edin.
        Thread.sleep(3000);
        WebElement addRemoveElementsText = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if(addRemoveElementsText.isDisplayed()) System.out.println("Add/Remove Elements visible. Test PASSED");
        else System.out.println("Add/Remove Elements invisible.Test FAİLED");
        Thread.sleep(3000);
        driver.close();

    }
}
