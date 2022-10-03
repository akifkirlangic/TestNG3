package Gun03;

/*
     Senaryo;
     1- Siteyi açınız
     2- Adres ekleyiniz.
     3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
     4- En son  adresi siliniz.
 */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends GenelWebDriver {

    @Test
    void addressBook()
    {
        WebElement addBook = driver.findElement(By.linkText("Address Book"));
        addBook.click();

        WebElement newAdd = driver.findElement(By.linkText("New Address"));
        newAdd.click();

        WebElement firstName = driver.findElement(By.cssSelector("[id='input-firstname']"));
        firstName.sendKeys("Mehmet Akif");

        WebElement lastName = driver.findElement(By.cssSelector("[id='input-lastname']"));
        lastName.sendKeys("Kırlangıç");

        WebElement company = driver.findElement(By.cssSelector("[id='input-company']"));
        company.sendKeys("TechnoStudy");

        WebElement ads1 = driver.findElement(By.cssSelector("[id='input-address-1']"));
        ads1.sendKeys("Sütlüce Mahallesi");

        WebElement ads2 = driver.findElement(By.cssSelector("[id='input-address-2']"));
        ads2.sendKeys("Talip Pasha Sk.");

        WebElement city = driver.findElement(By.cssSelector("[id='input-city']"));
        city.sendKeys("Beyoglu");

        WebElement postCode = driver.findElement(By.cssSelector("[id='input-postcode']"));
        postCode.sendKeys("34100");

        WebElement country=driver.findElement(By.id("input-country"));
        Select countryS=new Select(country);
        countryS.selectByVisibleText("Turkey");

        wait.until(ExpectedConditions.elementToBeClickable(country)); // ayrı bir wait cözümü
        //wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("select[id='input-zone']>option"))));
        //bu elemanın bayatlamış hali gidene kadar bekle

        WebElement State=driver.findElement(By.id("input-zone"));
        Select state=new Select(State);
        state.selectByIndex(10);
        // Action la da cözersek hic hata vermez.



      WebElement yesBtn = driver.findElement(By.cssSelector("input[value='1']"));
      yesBtn.click();

      WebElement contBtn = driver.findElement(By.cssSelector("input[value='Continue']"));
      contBtn.click();

        Tools.successMessageValidation();


    }

    @Test(dependsOnMethods = {"addressBook"})
    void editAddress()
    {
        WebElement addBook = driver.findElement(By.linkText("Address Book"));
        addBook.click();

        List<WebElement> editAll = driver.findElements(By.linkText("Edit"));
        WebElement sonEdit = editAll.get(editAll.size()-1); // en son eklenen edit i buldum burda.sondaki edit elemanı yani
        System.out.println("editAll = " + editAll.size());
        sonEdit.click();

        WebElement firstName = driver.findElement(By.cssSelector("[id='input-firstname']"));
        firstName.clear();
        firstName.sendKeys("Mehmet");

        WebElement lastName = driver.findElement(By.cssSelector("[id='input-lastname']"));
        lastName.clear();
        lastName.sendKeys("Temur");

        WebElement contBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        contBtn.click();

        Tools.successMessageValidation();
        // //*[text()='Edit']
    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress()
    {
        WebElement addBook = driver.findElement(By.linkText("Address Book"));
        addBook.click();

        List<WebElement> deleteAll = driver.findElements(By.linkText("Delete"));
        WebElement sonDelete = deleteAll.get(deleteAll.size()-2); // en sondan 2. eklenen edit i buldum burda.sondaki edit elemanı yani

        sonDelete.click();

        //Tools.successMessageValidation();

    }


}

  /*
       WebElement country=driver.findElement(By.id("input-country"));
       Select countryS=new Select(country);
       countryS.selectByIndex(10);

       WebElement State=driver.findElement(By.id("input-zone"));
       Select state=new Select(State);
       System.out.println("state.getOptions().size() 1 = " + state.getOptions().size());
/////////////
       wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("[id='input-zone']>option"),
                   state.getOptions().size()));
       // option ların sayısı ilk halinden küçük olana kadar bekle : yeni durum gelene kadar bekle
/////////////
       System.out.println("state.getOptions().size() 2 = " + state.getOptions().size());

       State=driver.findElement(By.id("input-zone"));
       state=new Select(State);

//       System.out.println("state.getOptions().size() = " + state.getOptions().size());
//       for(WebElement e: state.getOptions())
//           System.out.println(e.getText());

       state.selectByIndex(3);
       */