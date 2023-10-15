package tests.day07_Waits_Webtables;


import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.Cookie;
import tests.utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase{
    @Test
    public void CookieTesti(){
    //   1- Amazon anasayfaya gidin
        driver.get("https:amazon.com");
    //   2- tum cookie’leri listeleyin
       Set<Cookie> cookies =  driver.manage().getCookies();

        int cookieSirasi = 1;
        for (Cookie each: cookies
             ) {
            System.out.println(cookieSirasi + "-"+each);
            cookieSirasi++;
        }
    //   3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedMinSize = 5;
        int actualSize = cookies.size();
        Assert.assertTrue(actualSize>expectedMinSize);
    //   4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookieDegeri = "USD";
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedCookieDegeri,actualCookieValue);
    //   5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("EnSevdigimCookie","cikolatali");
        driver.manage().addCookie(cookie);
        System.out.println("===============");
        cookies =  driver.manage().getCookies();

         cookieSirasi = 1;
        for (Cookie each: cookies
        ) {
            System.out.println(cookieSirasi + "-"+each);
            cookieSirasi++;
        }
    //   6- eklediginiz cookie’nin sayfaya eklendigini test edin
         expectedCookieDegeri = "cikolatali";
         actualCookieValue = driver.manage().getCookieNamed("EnSevdigimCookie").getValue();
        Assert.assertEquals(expectedCookieDegeri,actualCookieValue);
    //   7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        System.out.println("===============");
        cookies =  driver.manage().getCookies();

        cookieSirasi = 1;
        for (Cookie each: cookies
        ) {
            System.out.println(cookieSirasi + "-"+each);
            cookieSirasi++;
        }

        boolean flag = true;
        for (Cookie each: cookies
             ) {
            if (each.getName().equals("skin")) flag = false;
        }
        Assert.assertTrue(flag);
    //   8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookies =  driver.manage().getCookies();
        System.out.println("===============");

        System.out.println("silindikten sonra cookiesSeti " + cookies);
        int expectedCookieSetSize = 0;
        int actualCookieSetSize = cookies.size();
      Assert.assertEquals(actualCookieSetSize,expectedCookieSetSize);

    }

}
