package tests.day02_Locaters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_FindElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //eğer locator dogur değilse driver html kodlarını implicitlyWait süresince inceler,bulamazsa o süre bitince kapanır.

        //amazon anasayfaya gidin
        driver.get("https:amazon.com");

        // armama kutusuna nutella yazdirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");

        // ve aramayi yapmak icin ENTER tusuna basin
        aramaKutusu.submit();
        //Thread.sleep(13000);
            driver.close();
    }
}
