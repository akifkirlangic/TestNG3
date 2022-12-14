package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParametreliWebDriver {

    public  WebDriver driver; // static oldugu zaman en son kim geldiyse o olur.yani önce bi tanesini sonra  diğerini çalıştırıyo.
                              // static i kaldırınca 2 side aynı anda ulaşıp aaynı anda calıstırıyo
    public static WebDriverWait wait ;

    @Parameters("browser")
    @BeforeClass
    public void BaslangicIslemleri(String browser){
        System.out.println("Driver start.....");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browser.equalsIgnoreCase("chrome")){

            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // outputtaki ilk 3 sıradaki sey cıkmaması icin sessize aldık(SLF ler)
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();

        }else
           if (browser.equalsIgnoreCase("firefox")){
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }



        //driver.manage().window().maximize(); // max
        driver.manage().deleteAllCookies();  // bunla her zaman yeni baglanıyomusuz gibi yapıyo. yani bize cooki sallamıyo site .rahatca girebiliyoz

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //Duration dr= Duration.ofSeconds(30);
        //driver.manage().timeouts().pageLoadTimeout(dr); // sadece ana sayfa yüklenirken en başta
        //driver.manage().timeouts().implicitlyWait(dr); // (her elemanın yüklemesi icin süre tanıyo)bütün webElement için geçerli

        //kısa hali
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // (her elemanın yüklemesi icin süre tanıyo)bütün webElement için geçerli

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");


        loginTest();

    }

    void loginTest()
    {
        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("makif@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("94927363");

        WebElement loginbtn = driver.findElement(By.cssSelector("input[value='Login']"));
        loginbtn.click();

    }

    @AfterClass
    public void BitisIslemleri(){
        System.out.println("Driver stop....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
