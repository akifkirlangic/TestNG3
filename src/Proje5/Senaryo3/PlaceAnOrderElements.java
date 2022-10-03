package Proje5.Senaryo3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;
import java.util.List;

public class PlaceAnOrderElements {
    public PlaceAnOrderElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "[value='Add to cart']")
    public List <WebElement> addToCart;

    @FindBy (xpath = "(//*[@value='Add to cart'])[1]")
    public WebElement addToCart2;

    @FindBy (css = "[id='giftcard_2_RecipientName']")
    public WebElement recipientName;

    @FindBy (css = "[id='giftcard_2_RecipientEmail']")
    public WebElement recipienteMail;

    @FindBy (css = "[value='18']")
    public WebElement HDD;

    @FindBy (css = "[id='product_attribute_75_5_31_96']")
    public WebElement slow;

    @FindBy (css = "[value='94']")
    public WebElement software;

    @FindBy (css = "[id='product_attribute_74_8_29_88']")
    public WebElement software2;

    @FindBy (xpath = "(//*[text()='Shopping cart'])[1]")
    public WebElement shooppingCart;

    @FindBy (css = "[name='CountryId']")
    public WebElement countryId;

    @FindBy (css = "[name='CountryId']>option")
    public List <WebElement> countries;

    @FindBy (css = "[name='StateProvinceId']>option")
    public WebElement statesOptions;

    @FindBy (id = "StateProvinceId")
    public WebElement statesId;

    @FindBy (css = "[id='StateProvinceId']")
    public WebElement statesClick;

    @FindBy (xpath = "//*[text()='California']")
    public WebElement statesClick2;

    @FindBy (css = "[id='termsofservice']")
    public WebElement aggreBox;

    @FindBy (css = "[id='checkout']")
    public WebElement checkBox;

    @FindBy (css = "[id='BillingNewAddress_Company']")
    public WebElement company;

    @FindBy (css = "[id='BillingNewAddress_CountryId']")
    public WebElement countriesBox;

    @FindBy (xpath= "//*[text()='United States']")
    public WebElement countries2;

    @FindBy (xpath= "//*[@id='BillingNewAddress_StateProvinceId']")
    public WebElement stateBox;

    @FindBy (xpath= "//*[text()='California']")
    public WebElement stateText;

    @FindBy (css= "[id='BillingNewAddress_City']")
    public WebElement city;

    @FindBy (css= "[id='BillingNewAddress_Address1']")
    public WebElement address1;

    @FindBy (css= "[id='BillingNewAddress_Address2']")
    public WebElement address2;

    @FindBy (css= "[id='BillingNewAddress_ZipPostalCode']")
    public WebElement zipCode;

    @FindBy(css = "[id='BillingNewAddress_PhoneNumber']")
    public WebElement phoneNumber;

    @FindBy(css = "[id='BillingNewAddress_FaxNumber']")
    public WebElement faxNumber;

    @FindBy(css = "[onclick='Billing.save()']")
    public WebElement Continue;

    @FindBy (css = "[onclick='Shipping.save()']")
    public WebElement shippingAddress;

    @FindBy (css = "[id='shippingoption_2']")
    public WebElement shippingMetod;

    @FindBy (css = "[onclick='ShippingMethod.save()']")
    public WebElement smContinue;

    @FindBy (css = "[id='paymentmethod_0']")
    public WebElement paymentMetod;

    @FindBy (css = "[onclick='PaymentMethod.save()']")
    public WebElement pmContinue;

    @FindBy (css = "[onclick='PaymentInfo.save()']")
    public WebElement pmInformatıon;

    @FindBy (css = "[value='Confirm']")
    public WebElement confirmOrder;

    @FindBy (xpath = "//*[text()='Your order has been successfully processed!']")
    public WebElement succesMessageValidation;

    @FindBy (xpath = "//*[@value='Continue']")
    public WebElement msgContinue;

    @FindBy (xpath = "(//*[@href='/customer/info'])[1]")
    public WebElement deleteEmail;

    @FindBy (xpath = "(//*[@href='/customer/addresses'])[1]")
    public WebElement deleteAddress;

    @FindBy (css = "[value='Delete']")
    public WebElement delete;





}
