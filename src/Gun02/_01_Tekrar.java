package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _01_Tekrar extends GenelWebDriver {

    @Test
    void topMenu() {
        List<String> beklenenListe = new ArrayList<>();
        beklenenListe.add("Desktops");
        beklenenListe.add("Laptops & Notebooks");
        beklenenListe.add("Components");
        beklenenListe.add("Tablets");
        beklenenListe.add("Software");
        beklenenListe.add("Phones & PDAs");
        beklenenListe.add("Cameras");
        beklenenListe.add("MP3 Players");

        By menuBulucu = By.xpath("//ul[@class='nav navbar-nav']/li");
        List<WebElement> gercekiListe = driver.findElements(menuBulucu);

        //Tools.compareToList(beklenenListe,gercekiListe);

        for (int i = 0; i < beklenenListe.size(); i++){
            System.out.println("Webteki menü : "+gercekiListe.get(i).getText());
            System.out.println("Beklenen menü : "+beklenenListe.get(i));
            Assert.assertEquals(beklenenListe.get(i),gercekiListe.get(i).getText(),"KArşılaştırma Sonucu :");
        }


    }


}
