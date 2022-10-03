package Proje5.Register;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPOM extends GenelWebDriver_Proje5 {

    @Test(dataProvider = "Users")
     void ProceedToRegister(String firstname,String lastname,String email,String password,String cfrnPassword){

        RegisterElements rgs=new RegisterElements(driver);

        rgs.regisTer.click();
        rgs.genderMale.click();
        rgs.firstName.sendKeys(firstname);
        rgs.lastName.sendKeys(lastname);
        rgs.eMail.sendKeys(email);
        rgs.password.sendKeys(password);
        rgs.confirmPassword.sendKeys(cfrnPassword);
        rgs.registerButton.click();

    }
    @DataProvider
    public  Object[][] Users() {

        Object[][] data= {
                {"semih", "sozen", "sozen1234@outlook.com", "sozen1234", "sozen1234"}
        };

        return  data;
    }
}
