package Gun06;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Daha önceki derslerde yaptğımı Search fonksiyonunu
 * mac,ipod ve samsung için Dataprovider ile yapınız.
 */

public class _04_Task extends GenelWebDriver {

    @Test(dataProvider = "getData")
    void userNameTest(String marka)
    {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));
        searchBox.clear();
        searchBox.sendKeys(marka);

        WebElement button= driver.findElement(By.xpath("(//button[@class='btn btn-default btn-lg'])[1]"));
        button.click();


        List<WebElement> captions = driver.findElements(By.cssSelector("[class='product-thumb'] [class='caption'] a"));

        for (WebElement e : captions) {
            Assert.assertTrue(e.getText().toLowerCase().contains(marka));
        }
    }

    @DataProvider  // bu metoda dataprovider görevi verildi. dataları tek tek teste gönder for gibi
    public Object[] getData()  // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
    {
        Object[] data = {"mac","ipod","samsung"};

        return data;
    }









    }





