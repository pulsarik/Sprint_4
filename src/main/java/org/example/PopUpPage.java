package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopUpPage {
    WebDriver driver;
    private final By PopUpHeader = By.xpath(".//div[text()='Заказ оформлен']");
    private final By buttonStatus = By.xpath("//*[text()='Посмотреть статус']");
    ;

    public PopUpPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickOnYes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonStatus));
        element.click();
    }

    public String getHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> (driver.findElement(PopUpHeader).getText() != null
                && !driver.findElement(PopUpHeader).getText().isEmpty()
        ));
        return driver.findElement(PopUpHeader).getText();
    }

    public boolean cancelButtonPresent()
    {
        By buttonLocator = By.xpath("//*[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and contains(@class, 'Button_Inverted__3IF-i')]");
        List<WebElement> buttons = driver.findElements(buttonLocator);
        return !buttons.isEmpty();
    }
}