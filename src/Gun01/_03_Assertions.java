package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {
    // yesil tik : testte hata yok
    // sarı çarpı : testte hata var
    // beyaz : test çalıştırılmadı. (skip)


    @Test
    void EqualOrnek() {    // burada stringler esit  mi diye karşılasştırdık sari carpi aldık.
        String s1 = "Merhaba";
        String s2 = "İyi akşamlar";

        // (s1, s2,"Karsilastirma sonucu") --> (oluşan , beklenen , "hata başlığı")
        Assert.assertEquals(s1, s2,"Karsilastirma sonucu");
        // Actual : oluşan(gerceklesen)
        // Expected : beklenen

    }

    @Test            // burada stringler esit degil mi diye karşılasştırdık yesil tik aldık
    void NotEqualOrnek() {
        String s1 = "Merhaba";
        String s2 = "İyi akşamlar";

        // (s1, s2,"Karsilastirma sonucu") --> (oluşan , beklenen , "hata başlığı")
        Assert.assertNotEquals(s1, s2,"Karsilastirma sonucu");
        // Actual : oluşan(gerceklesen)
        // Expected : beklenen

    }



    @Test            // burada intler esit degil mi diye karşılasştırdık yesil tik aldık
    void TrueOrnek() {
        int s1 = 55;
        int s2 = 555;

        // (s1, s2,"Karsilastirma sonucu") --> (oluşan , beklenen , "hata başlığı")
        Assert.assertTrue(s1==s2,"Karsilastirma sonucu");
        // Actual : oluşan(gerceklesen)
        // Expected : beklenen

    }

    @Test
    void NullOrnek() {
        String s1 = null;

        Assert.assertNull(s1,"Karsilastirma sonucu");
    }

    @Test  // örnegin if ile kullanıcaz : yanlış parola ile sisteme girersen direk fail ver gidip developer döveceğiz :)
    void direktFail() {
        int a=55;
        if (a==55)
          Assert.fail();
    }




}
/*
primitive (int gibi) tip null olamaz . Ben yazılım notasyonuna hakimim demek
 */