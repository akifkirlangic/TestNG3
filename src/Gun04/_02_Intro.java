package Gun04;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _02_Intro {

    @Test
    void Test1(){System.out.println("Test 1");}

    @Test
    void Test2(){System.out.println("Test 2");}

    @BeforeTest
    void aTest(){System.out.println("Before a Test");}

    //Aynı annotation dan olursa Class isminin alfabetik sırasına göre çalışır



}
/*
Bu ikisini aynı anda calıstırmak istiyor musun diyo testNG ya da hepsni tüm testleri yani
 File>Settings>Plugins>Aramaya xml yaz>Create TestNG XML Install tıkla>Accept

 */