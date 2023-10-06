package tests.Day04_JunitFrameWork_DropDown;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertions {
int sayi1 = -20;
int sayi2 = 10;

// sayi1'in cift olup olmadigini test edin


    @Test
    public void ciftSayiTesti(){
        //sayi1'in cift olup olmadigini test edin
        Assert.assertTrue("sayi1 cift degil",sayi1%2==0);


    }

    @Test
    public void PozitifSayiTesti(){
        //sayi1'in cift olup olmadigini test edin
Assert.assertTrue("sayi1 pozitif degil" , sayi1 > 0);
    }

    @Test
    public void karsılastimaTesti(){
        //sayi1'in cift olup olmadigini test edin

     Assert.assertTrue("sayi1 sayi2 den buyuk degil",sayi1>sayi2);
    }
    @Test
    public void ciftSayiTesti1(){
        //sayi1'in sayi2 'den kucuk oldugunu test edin
        // sayi1 < sayi2 ==> true olmali
        Assert.assertTrue(sayi1<sayi2);


    }

    @Test
    public void PozitifSayiTesti1(){
        //sayi1 sayi2'ye esit mi
        // sayi1 == sayi2 ==> true olmali
        Assert.assertEquals( sayi1,sayi2);
    }

    @Test
    public void karsılastimaTesti1(){
        //sayi1 ile sayi2'nin esit olmadigi test edin
        //sayi1 == sayi2 == > false olmali
        Assert.assertNotEquals(sayi1,sayi2);
    }

}
