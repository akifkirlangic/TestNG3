package Gun07;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {  // bu konu: programın kırılmasını istemediğin ama hatalarında gösterildiği bir konu

    @Test
    void hardAssert()
    {
       String s1="Merhaba";

        System.out.println("Hard assert öncesi");
        Assert.assertEquals("Merhaba 123",s1,"HardAssert Sonucu");
        System.out.println("Hard assert sonrası");  // hard assert hata verdikten sonra çalışmaz
    }

    @Test
    void softAssert()
    {
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";


        SoftAssert _softAssert = new SoftAssert();  // hataları içinde biriktiryo biriktiryo sonra bi anda veriyo
        _softAssert.assertEquals("www.facebook.com/homepage",strHomePage); // true ; hata oluşmayacak burda
        System.out.println("assert 1");

        _softAssert.assertEquals("www.facebook.com/profile",strHomePage); // fail ; hata oluşacak burda
        System.out.println("assert 2"); // bu hatayı sakladı burda . yani hatayı tuttu

        _softAssert.assertEquals("www.facebook.com/settings",strEditAccount); // fail
        System.out.println("assert 3");

        _softAssert.assertAll(); // bütün assert sonuclarını işleme koyuyor burada
        System.out.println("Aktiflik sonrası"); // bubölüm assertAll dan sonra oldugu ve öncesinde hata olustugu için , bu sout yazılmadı


    }



}
