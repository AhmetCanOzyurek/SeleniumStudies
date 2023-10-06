package tests.Day04_JunitFrameWork_DropDown;

import org.junit.Test;

public class C01_Assertions {
    int sayi1 = 10;
    int sayi2 = -20;
/*
JUnit bir test methodu calistirilirken
hic bir hata almyorsa
testi PASSED olarak isaretler

testin FAİLED olmasi icin
test method'u calisirken exception olusmalidir
 */


    @Test
    public void ciftSayiTesti(){
        //sayi1'in cift olup olmadigini test edin

        if (sayi1 %2 == 0) System.out.println("cift sayi testi PASSED");
        else System.out.println("Cift sayi testi FAİLED");
    }

    @Test
    public void PozitifSayiTesti(){
        //sayi1'in cift olup olmadigini test edin

        if (sayi2 > 0) System.out.println("pozitif sayi testi PASSED");
        else System.out.println("pozitif sayi testi FAİLED");
    }

    @Test
    public void karsılastimaTesti(){
        //sayi1'in cift olup olmadigini test edin

        if (sayi1 > sayi2) System.out.println("Karsilastirme testi PASSED");
        else System.out.println("Karsilastirme testi FAİLED");
    }


}
