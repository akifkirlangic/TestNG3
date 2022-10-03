package Proje5.Senaryo2;

import Proje5.Register.GenelWebDriver_Proje5;
import Proje5.Register.RegisterElements;
import Proje5.Senaryo1.LoginElements;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InValidLoginPOM extends GenelWebDriver_Proje5 {

    @Test (dataProvider = "getData")
    void InValidLogin(String eMail,String password){
        RegisterElements reg=new RegisterElements(driver);
        LoginElements log=new LoginElements(driver);

        log.loginButton.click();
        reg.eMail.sendKeys(eMail);
        reg.password.sendKeys(password);
        log.rememberMe.click();
        log.Login.click();
        Assert.assertTrue(log.InValidLoginText.getText().contains("unsuccessful"));

    }

    @DataProvider
    public Object [][] getData(){
        Object [][] data={{"sozenemeç1234@outlook.com","sever1234"}};
        return data;

    }
}
