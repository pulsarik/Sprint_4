

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    private final By cookieButton = By.id("rcc-confirm-button");
    private final String URL = "https://qa-scooter.praktikum-services.ru/";
    @Before
    public void startUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/borisz/chromeWebDriver");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(cookieButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}