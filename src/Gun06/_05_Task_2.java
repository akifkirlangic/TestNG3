package Gun06;

import Utils.ParametreliWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Bir önceki task da yapılan testi PARAMETERDRIVER ile yapınız
 * sonrasında fakrlı tarayıcılar ile çalıştırınız.
 * sonrasında paralel çalıştırınız.
 */

public class _05_Task_2 extends ParametreliWebDriver {


    @Parameters("arananKelime")
    @Test(dataProvider = "getData")
    void searchFunction(String txtSearch)
    {
        //driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search']"));
        searchBox.clear();
        searchBox.sendKeys(txtSearch);

        WebElement button= driver.findElement(By.xpath("(//button[@class='btn btn-default btn-lg'])[1]"));
        button.click();

        // ya da h4>a
        List<WebElement> captions = driver.findElements(By.cssSelector("[class='product-thumb'] [class='caption'] a"));

        for (WebElement e : captions) {
            Assert.assertTrue(e.getText().toLowerCase().contains(txtSearch));
        }
    }

    @DataProvider
    public Object[] getData()  // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
    {
        Object[] data = {"mac","ipod","samsung"};

        return data;
    }



}
