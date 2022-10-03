package Gun07;

/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_PlaceOrderPOM extends GenelWebDriver { // POM : Page Object Model

    @Test
    void ProceedToCheckOut() {

        // TODO : sayfa kücük oldugunda sıkıntı çıkarıyormu, maximize kullanmadan
        //  sağlıklı çalıştırılması araştırılacak


        _03_PlaceOrderElements elements = new _03_PlaceOrderElements(driver);

        driver.manage().window().maximize();

        elements.searchBox.sendKeys("ipod"); //.NullPointerException hatası verdi basta çalıştırırken yani elementi bulamıyo yok diyo. Driverı bulamdığı için bulamıyo sorun burdan geliyo. Boş bi constructor istiyo pom.
        elements.searchButton.click();
        elements.addToCart.click();
        elements.shoppingCart.click();
        elements.checkout.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
        elements.agree.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
        elements.confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.confirmTxt.getText(), "Your order has been placed!", "Karşılaştırma Sonucu : ");




    }

}
