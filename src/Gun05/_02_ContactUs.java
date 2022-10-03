package Gun05;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact Us yazısını doğrulayınız.
 */

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_ContactUs extends GenelWebDriver {


    @Test  // xml de çalıstırcaz -> _06_ContactUs.xml
    @Parameters("mesaj")  // XML deki adı
    void contactUs(String gelenMesaj)  // metoddaki adi
    {
        driver.manage().window().maximize(); // bununla submitteki hatayı cozdük.
        WebElement contact= driver.findElement(By.linkText("Contact Us"));
        contact.click();

        WebElement enquiry = driver.findElement(By.xpath("//textarea[@id='input-enquiry']"));
        enquiry.sendKeys(gelenMesaj);

        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Submit']")));
        WebElement submit = driver.findElement(By.cssSelector("[value='Submit']"));
        submit.click();

        WebElement contactUsLabel = driver.findElement(By.cssSelector("[id='content']>h1"));
        System.out.println(contactUsLabel.getText());

        Assert.assertEquals("Contact Us",contactUsLabel.getText(),"Karşılaştırma sonucu");
    }

}
