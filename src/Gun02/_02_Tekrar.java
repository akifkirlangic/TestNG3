package Gun02;
/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız. newsletter->yes->continue->dogrula ve no yu da yap.
  3- Newsletter  üyelik işlemini, üye ise , üyelikten çıkma, değilse ekleme şeklinde yapınız (yes ise no , no ise yes yap)
 */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Tekrar extends GenelWebDriver {

    By newsletterHtml = By.linkText("Newsletter");

    By yesHtml = By.cssSelector("[value='1']");

    By contHtml = By.cssSelector("[value='Continue']");

    By noHtml = By.cssSelector("[value='0']");


    @Test(priority = 1)
    void subscribeFunctionYes() {
        WebElement newsletterBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(newsletterHtml));
        newsletterBtn.click();

        WebElement yesBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(yesHtml));
        yesBtn.click();

        WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(contHtml));
        continueBtn.click();

        // Tools a eklediğimiz kısım
        WebElement validateGreenTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='alert alert-success alert-dismissible']")));
        Assert.assertTrue(validateGreenTxt.getText().contains("Success"));

    }

    @Test(priority = 2)
    void subscribeFunctionNo() {
        WebElement newsletterBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(newsletterHtml));
        newsletterBtn.click();

        WebElement noBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(noHtml));
        noBtn.click();

        WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(contHtml));
        continueBtn.click();

        Tools.successMessageValidation();

    }

    @Test(priority = 3)
    void subscribeFunctionYesOrNo() {
        WebElement newsletterBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(newsletterHtml));
        newsletterBtn.click();

        WebElement yesBtn = driver.findElement(yesHtml);
        WebElement noBtn = driver.findElement(noHtml);

        if (yesBtn.isSelected())
            noBtn.click();
        else
            yesBtn.click();


        WebElement continueBtn = driver.findElement(contHtml);
        continueBtn.click();

        Tools.successMessageValidation();
    }


}
