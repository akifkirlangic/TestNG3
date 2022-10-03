package Gun02;
/*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.
     */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class _03_EditAccount extends GenelWebDriver {


    @Test
    void EditAccount()
    {
        editAccount("Ahmet","Demir");
        Tools.Bekle(3);
        editAccount("Mehmet Akif","Kırlangıç");
    }



    void editAccount(String ad , String soyad) {

        WebElement editAcc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-group']/a[2]")));
        editAcc.click();

        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));
        firstName.clear();
        firstName.sendKeys(ad);

        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lastname']")));
        lastName.clear();
        lastName.sendKeys(soyad);

        WebElement contAcc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Continue']")));
        contAcc.click();

        Tools.successMessageValidation();


    }

}
