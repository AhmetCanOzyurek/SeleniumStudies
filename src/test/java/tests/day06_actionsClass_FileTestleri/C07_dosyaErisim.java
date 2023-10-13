package tests.day06_actionsClass_FileTestleri;

import com.sun.source.tree.SynchronizedTree;
import org.junit.Test;

public class C07_dosyaErisim {
    @Test
    public void dosyaTesti01(){
        System.out.println(System.getProperty("user.home "));

        /*
        Selenium bilgisayarimiza ulasamaz  ve
        bilgisayarimizdaki dosyalari test edemez

        bilgisayarimizdaki dsyalarla ilgili islemler icin java'dan yardim alabiliriz

        Javva'nin bilgisayarimizdaki bir dosyaya ulasabilmesi icin ise
        dosya yoluna ihtiyaci vardir

        Testimiz birden fazla bilgisayarda calisacaksa
        her bilgisayarin dosya yapisi farkli olacağından
        dosya testleri hata verebilir

        bu hatlarin onuna gecmek icin
        dosya yollarimizi dinamik yapmayi tercih ederiz

        dosya yolunu 2 parcaya ayiralim
        1- sadece benş bilgisayarima ozel kisim
        2 - varsa onedrive kismi
        3 - herkeste olan ortak kisim

        /Users/enesoncu   Onedrive    /Masaüstü/sample.png

         */

        String  dinamikDosyaYolu = System.getProperty("user.home") + "OneDrive" + "/Masaüstü/sample.png";
    }
}
