

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    private static final By cookieButton = By.id("rcc-confirm-button");
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    @BeforeClass
    public static void startUp() {
      //  System.setProperty("webdriver.chrome.driver", "/Users/borisz/chromeWebDriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        driver.findElement(cookieButton).click();
    }
    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}