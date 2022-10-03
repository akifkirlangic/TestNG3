package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {

    //public static void main(String[] args) {
    //    webSitesiniAc();
    //    LoginTestIsleminiYap();
    //    driviriKapat();
    //}

    //Eger test metotlarına sıralama verilmezse alfabetik sırasına göre calisir.

    @Test(priority = 1) // annotation lar (not ekleme gibi yani bu metodun ne olacağını karar veriyorum )
    void webSitesiniAc() {
        System.out.println("Driver tanimlandi ve web sitesi acildi.");
    }

    @Test(priority = 2) // priority öncelik sırası demektir.
    void loginTestISleminiYap() {
        System.out.println("Login test islemleri yapildi.");
        // yesil tik ; hatalı assertion yok demektir. // konsolun sağ tarafı gercek sırayı gösteriyo
    }

    @Test(priority = 3)
    void driveriKapat() {
        System.out.println("driver kapatildi ve cikildi.");
    }

    // Not : eger metotlarda sıralamayı biz yapmazsak. kendisi alfabetik sırayla test sonucunu(cıktı kısmı sol taraf değil) veriyo.
    // Ama mesala metotlardan biri büyük harfle baslasaydı ilk o test sonucu verirdi gibi.



}
