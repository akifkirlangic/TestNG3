package Proje5.Senaryo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {
    public LoginElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "[class='ico-login']")
    public WebElement loginButton;

    @FindBy (css = "[id='RememberMe']")
    public WebElement rememberMe;

    @FindBy (css = "[value='Log in']")
    public WebElement Login;

    @FindBy (linkText = "Log out")
    public WebElement logOutCheck;

    @FindBy (css = "[class='validation-summary-errors']")
    public WebElement InValidLoginText;






}
