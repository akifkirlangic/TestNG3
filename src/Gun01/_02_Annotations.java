package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {
    /*
         @BeforeClass --> // Her class calisiyorken önce burasi calisir
            @BeforeMethod --> // Her metoddan(test metod) önce calisir
               @Test    -->  testlerin çalıştığı metodlar
               @Test    -->  testlerin çalıştığı metodlar
            @After Method --> // Her metoddan (test metod)  sonra calisir
         @AfterClass --> // Her class çalışıyorken sonra burası çalışır

     */

    /*

    @BeforeSuit
       @BeforeTest
         @BeforeGroups
             @BeforeClass
                @BeforeMethod
                   @Test
                   @Test
                @AfterMethod
             @AfterClass
         @AfterGroups
      @AfterTest
    @AfterSuit

     */

    @BeforeClass
    void beforeClass(){
        System.out.println("Her class dan önce calisacak : Before Class");
    }

    @BeforeMethod
    void beforeMethod(){ System.out.println("Her test metod dan önce calisacak : Before Method"); }



    @AfterMethod
    void afterMethod(){ System.out.println("Her test metod dan sonra calisacak : After Method"); }

    @AfterClass
    void  afterClass(){
        System.out.println("Her class dan sonra calisacak : After Class");
    }

    @Test
    void test1(){
        System.out.println("Test 1 calisti");
    }

    @Test
    void test2(){
        System.out.println("Test 2 calisti");
    }


}

/*
ÇIKTIMIZ AŞAĞIDAKİ GİBİDİR

Her class dan önce calisacak : Before Class

Her test metod dan önce calisacak : Before Method
Test 1 calisti
Her test metod dan sonra calisacak : After Method

Her test metod dan önce calisacak : Before Method
Test 2 calisti
Her test metod dan sonra calisacak : After Method

Her class dan sonra calisacak : After Class

===============================================
Default Suite
Total tests run: 2, Failures: 0, Skips: 0
===============================================

 */