package Proje5.Senaryo3;

import Proje5.Register.GenelWebDriver_Proje5;
import Proje5.Register.RegisterElements;
import Proje5.Senaryo1.LoginElements;
import Proje5.Senaryo1.ValidLoginPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PlaceAnOrderPOM extends GenelWebDriver_Proje5 {
    @Test (dataProvider = "getData")
    void PlaceAnOrder(String name,String eMail){

        PlaceAnOrderElements elements=new PlaceAnOrderElements(driver);
        LoginElements log=new LoginElements(driver);

        log.loginButton.click();
        ValidLoginPOM.LoginIn("sozen1234@outlook.com","sozen1234");
        int rndListe=RandomGenerator(elements.addToCart.size());
        elements.addToCart.get(rndListe).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        if (rndListe==0) {
            elements.recipientName.sendKeys(name);
            elements.recipienteMail.sendKeys(eMail);

        }
        else if (rndListe==3) {
            elements.HDD.click();
        }
        else if (rndListe==5) {
            elements.slow.click();
        }
        else if (rndListe==2) {
            elements.software.click();
        }
        else if (rndListe==4) {
            elements.software2.click();
        }

        elements.addToCart2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        elements.shooppingCart.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(elements.countryId));//countryId

        Select menu=new Select(elements.countryId);
        List<WebElement> countries=elements.countries;
        WebElement selectUSA=countries.get(1);
        menu.selectByValue(selectUSA.getAttribute("value"));

        wait.until(ExpectedConditions.elementToBeClickable(elements.statesClick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.statesClick2)).click();

        elements.aggreBox.click();
        elements.checkBox.click();
        elements.company.sendKeys("tesla");
        wait.until(ExpectedConditions.elementToBeClickable(elements.countriesBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.countries2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.stateBox)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.stateText)).click();
        elements.city.sendKeys("San Francisco");
        elements.address1.sendKeys("Cibeles");
        elements.address2.sendKeys("Neptunes");
        elements.zipCode.sendKeys("454444");
        elements.phoneNumber.sendKeys("05453563456");
        elements.faxNumber.sendKeys("12333323");
        elements.Continue.click();
        elements.shippingAddress.click();
        elements.shippingMetod.click();
        elements.smContinue.click();
        elements.paymentMetod.click();
        elements.pmContinue.click();
        elements.pmInformatıon.click();
        elements.confirmOrder.click();
        Assert.assertTrue(elements.succesMessageValidation.getText().contains("Your order has been successfully processed!"));
        elements.msgContinue.click();
        elements.deleteEmail.click();
        elements.deleteAddress.click();
        elements.delete.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }
    public static int RandomGenerator(int max) {
        return  (int)(Math.random() * max);  //max 4 =>  0 1 2 3
    }
    @DataProvider
    public Object [][] getData(){
        Object [][] data={{"hüseyin","sozen1234@outlook.com"}};
        return data;
    }
}

