package tests.day01_driverMethodları;

import com.sun.source.doctree.InlineTagTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_ılkClass {
    public static void main(String[] args) throws InterruptedException {
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https:amazon.com");

        Thread.sleep(5000);
        driver.close();

    }
}
