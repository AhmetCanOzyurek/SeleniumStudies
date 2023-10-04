package tests.day01_driverMethodları;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_driverMethodları {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();

        driver.get("https://www.amazon.com");

        System.out.println(driver.getCurrentUrl()); //https://www.amazon.com/

        System.out.println(driver.getTitle());//Amazon.com. Spend less. Smile more.

            System.out.println(driver.getWindowHandle());//80FC3853BA547D7C476715761D87D4A6

        System.out.println(driver.getWindowHandles());//[80FC3853BA547D7C476715761D87D4A6]
        System.out.println(driver.getPageSource());

        
        Thread.sleep(3000);
        driver.close();
    }

}
