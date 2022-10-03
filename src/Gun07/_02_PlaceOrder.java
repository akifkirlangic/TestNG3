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

public class _02_PlaceOrder extends GenelWebDriver {

    @Test
    void ProceedToCheckOut()
    {
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.cssSelector("[name='search']"));
        searchBox.sendKeys("ipod");

        WebElement searchBtn = driver.findElement(By.cssSelector("[class='btn btn-default btn-lg']"));
        searchBtn.click();

        WebElement addToCart = driver.findElement(By.xpath("(//div[@class='button-group']/button)[1]"));
        addToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']/a[2]")));
        WebElement shoppingCart = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/a[2]"));
        shoppingCart.click();


        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pull-right']/a]")));
        WebElement checkOut = driver.findElement(By.xpath("//a[text()='Checkout']"));
        checkOut.click();

        WebElement cont1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        cont1.click();

        WebElement cont2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        cont2.click();

        WebElement cont3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        cont3.click();

        WebElement agreeCheck = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("agree"))));
        agreeCheck.click();

        WebElement cont4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        cont4.click();

        WebElement  confirm=driver.findElement(By.id("button-confirm"));
        confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));  // url de success (gözükene) olana kadar bekledik
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Success")));
        WebElement h1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='content']>h1")));
        System.out.println(h1.getText());
        Assert.assertEquals(h1.getText(),"Your order has been placed!","Karşılaştırma Sonucu : ");

        //Assert.assertTrue(driver.findElement(By.cssSelector("div[id='content']")).getText().contains("order has been placed"));

    }

}
