package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Tools {

    public static void compareToList(List<String> menuExpectedList, List<WebElement> menuActualList) {

        for (int i = 0; i < menuExpectedList.size(); i++)
            Assert.assertEquals(menuExpectedList.get(i), menuActualList.get(i).getText(),"Karşılaştırma Sonucu");

    }

    public static void successMessageValidation(){

        WebElement yesilYaziDogrulama = GenelWebDriver.driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(yesilYaziDogrulama.getText().toLowerCase().contains("success"));
        System.out.println("Validate Text: "+yesilYaziDogrulama.getText());

    }

    public static void Bekle(int saniye)
    {
        try {
            Thread.sleep(saniye*300); // sürekli 3000 yazmamak icin saniye*1000 yaptım.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static double WebElementToDouble(WebElement e){
        String result = e.getText();
        result=result.replaceAll("[^\\d]","");
        return Double.parseDouble(result);

    }


    public static int RandomGenerator(int max)
    {
        return (int)(Math.random()*max); // max 4 ise burası 0 1 2 3 olacak sonuncu alınmıyor
    }



}