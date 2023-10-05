package tests.day03_JUni;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZeroWebb {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        WebElement signInButton = driver.findElement(By.xpath("//*[@class = 'signin btn btn-info']"));
        signInButton.click();
        //3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@id = 'user_login']")).sendKeys("username");
        //4. Password alanina “password” yazdirin
        driver.findElement(By.xpath("//input[@id = 'user_password']")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value= 'Sign in']")).click();
        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("300");
        //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Pay']")).click();
        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
    WebElement paymentSuccess = driver.findElement(By.xpath("//*[@id='alert_content']"));
    if (paymentSuccess.isDisplayed()) System.out.println("Payment Success visible. Test PASSED");
    else System.out.println("Payment success invisible. Test FAİLED");
        Thread.sleep(3000);
        driver.close();





    }
}
