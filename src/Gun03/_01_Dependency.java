package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
   interviewlarda sorulan bir konu : testlere öncelikleri nasıl verirsin ?
   priority, dependecy;   Nasıl kullanırsın ?
   1- priority =1 gibi sıralı rakamlar vererek bununla çalışma sırasını belirtirim.
   2- dependOnMethods : bununla kendinden önce hangi metod çalışması gerekiyor ise onu belirtirim.

   // bir metodu çalıştırdığınızda  kendinden önce 1 veya daha fazla var ise otomatik onları önce çağırıp
   sonra kendisi çalışır.Fakat 2 veya daha fazla tane var ise bağımlı olduğu metod o zaman çalışamaz.
 */
public class _01_Dependency {

    @Test
    void startCar()
    {
        System.out.println("Car started!");
    }

    @Test(dependsOnMethods = {"startCar"}) // bu testin çalışması, startCar ın hatasız çalışmasına bağımlı
    void driveCar()
    {
        System.out.println("Car driven!");
        //Assert.fail();  // skip kavramını(durumunu) görmek için yaptık .
    }


    @Test(dependsOnMethods = {"startCar","driveCar"},alwaysRun = true)// bu testin çalışması için verilen 2 testin hatasız bitmesi lazım
    void parkCar()
    {
        System.out.println("Car parked!");
    }

    @Test(dependsOnMethods = {"parkCar"},alwaysRun = true) // alwaysRun = true -> bağımlılıkları var ama hata cıkarsa da yine calışır
    void stopCar()                                         // alwaysRun = true : ne olursa olsun(bağımlılık bozulduysa bile) testin çaışmasını istediğim durumlarda kullanırım
    {
        System.out.println("Car stop!");
    }




}
