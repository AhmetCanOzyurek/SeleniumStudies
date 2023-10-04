package tests.day03_JUni;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html ");
       // 2 ) Berlin’i  3 farkli relative locator ile locate edin
//<img id="pid7_thumb" src="bots/sl-berlin-bot.png" class="ui-li-thumb">
        /*
        Relative locator HTML kodlarına ulasabildigimiz ancak
        Locate edemediğimiz elementleri etrafindaki elementleri kullanarak
        locate etmemize izin veriri

        berlin elementinin HTML kodlari

        3 ) Relative locator’larin dogru calistigini test edin
         */
        WebElement sailor = driver.findElement(By.id("pid11_thumb"));
        WebElement NYC = driver.findElement(By.id("pid3_price"));
        WebElement Boston = driver.findElement(By.id("pid6_thumb"));
        //tag2i img olup, sailor'in ustundeki element
        WebElement Berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor));
        // class attribute degeri ui-li-thumb olup nyc'nin altinda
        Berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(NYC));

//src attribute degeri bots/sl-berlin-bot.png olup bostonun sagında
        Berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(Boston));

        if(Berlin1.getAttribute("class").equals("ui-li-thumb")) System.out.println("Berlin1 locatorı çalışıyor");
        else System.out.println("Berlin1 locatorı calismiyor");
        Thread.sleep(3000);
        driver.close();

    }
}
