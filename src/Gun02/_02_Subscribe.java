package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.
  3- Newsletter  üyelik işlemini, üye ise , üyelikten çıkma, değilse ekleme şeklinde yapınız (yes ise no , no ise yes yap)
 */
public class _02_Subscribe extends GenelWebDriver {

    By link = By.linkText("Newsletter");

    By yes = By.cssSelector("input[value='1']");

    By no =  By.cssSelector("input[value='0']");

    By cntBtn = By.cssSelector("input[value='Continue']");

    @Test(priority = 1)
    void subscribeFunctionYes(){

        WebElement newsletterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        newsletterLink.click();

        WebElement accept = driver.findElement(yes);
        accept.click();

        WebElement continueButton = driver.findElement(cntBtn);
        continueButton.click();

        Tools.successMessageValidation();

    }

    @Test(priority = 2)
    void subscribeFunctionNo(){

        WebElement newsletterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        newsletterLink.click();

        WebElement NoAccept = driver.findElement(no);
        NoAccept.click();

        WebElement continueButton = driver.findElement(cntBtn);
        continueButton.click();

        Tools.successMessageValidation();

    }

    // sorunun 3. kısmı

    @Test(priority = 3)
    void subscribeFunctionForBoth(){

        WebElement newsletterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(link));
        newsletterLink.click();

        WebElement yesRadioButton = driver.findElement(yes);
        WebElement noRadioButton = driver.findElement(no);

        if (yesRadioButton.isSelected())
            noRadioButton.click();
        else
            yesRadioButton.click();


        WebElement continueButton = driver.findElement(cntBtn);
        continueButton.click();

        Tools.successMessageValidation();

    }






}
