package Proje5.Senaryo1;

import Proje5.Register.GenelWebDriver_Proje5;
import Proje5.Register.RegisterElements;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidLoginPOM extends GenelWebDriver_Proje5 {

    @Test(dataProvider = "getData")
    public static void LoginIn(String eMail,String password){

        LoginElements login=new LoginElements(driver);
        RegisterElements reg=new RegisterElements(driver);

        login.loginButton.click();
        reg.eMail.sendKeys(eMail);
        reg.password.sendKeys(password);
        login.rememberMe.click();
        login.Login.click();
        Assert.assertTrue(login.logOutCheck.isDisplayed());


    }
    @DataProvider
    public  Object[][] getData(){
        Object[][] data={{"sozen1234@outlook.com","sozen1234"}};

        return data;

    }
}
