package Proje5.Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterElements {
    public RegisterElements(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    @FindBy(linkText = "Register")
    public WebElement regisTer;

    @FindBy(css = "[id='gender-male']")
    public WebElement genderMale;

    @FindBy(css = "[id='FirstName']")
    public WebElement firstName;

    @FindBy(css = "[id='LastName']")
    public WebElement lastName;

    @FindBy(css = "[id='Email']")
    public WebElement eMail;

    @FindBy(css = "[id='Password']")
    public WebElement password;

    @FindBy(css = "[id='ConfirmPassword']")
    public WebElement confirmPassword;

    @FindBy(css = "[id='register-button']")
    public WebElement registerButton;




}
