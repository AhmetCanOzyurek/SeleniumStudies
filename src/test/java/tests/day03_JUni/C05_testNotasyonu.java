package tests.day03_JUni;

import org.junit.Ignore;
import org.junit.Test;

public class C05_testNotasyonu {


    /*
    @Test notasyonu, method'lara bagimsiz olarak calistirilabilme yetenegi katar.



    Testelerin bagımsız olarak calisabilmesi
    FrameWork uzerinde bu test methodlarından lusan farkli test gruplarini
    istedigimiz zmanalarda calistirabilme imkani tanir

    Testlerin buyukluklerine gore testleri su sekilde siralayabiliriz

    Test Suit (Birden fazla test icerir)
            - Smoke Test
            - Entegrasyon Testleri
            - End2End Testing
            - Regression
     Test : Bir amac icin bir araya getirilmis
            Test class'lari, Test Methodlari veya Package'lardan olusur
            ornegin bizim Smoke testimiz ici
            - day01 package'indaki tum class'lar
            -day02 den C01 ve C03
            - day03 deki C05 class2indaki test01 ve test02 test method'lari calissin diyebiliriz


           ayni test method'lari, class'Lar veya package'lar
           birden fazla Test icin calistirilabilir

        JUnit testlerin bagimsiz olarak calisitirilabilmesine imkan tanir
        ANCAK siralamayi kontrol etmez
        bizim kontrol etmemize de imkan tanimaz

        JUnit @Test kullanan method'Larin static olarak isaretlenmesine izin vermez

      "1. Method test=1() should not be static." hatasi verir.

     */
@Test
    public void test01(){
    System.out.println("test01 calisti");
}
    @Test @Ignore
    public void test02(){
        System.out.println("test02 calisti");
    }


    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }



}

