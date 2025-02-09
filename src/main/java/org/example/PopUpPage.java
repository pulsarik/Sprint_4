package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpPage {
    WebDriver driver;
    private final By PopUpHeader = By.xpath(".//div[text()='Заказ оформлен']");
    private final By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public PopUpPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickOnYes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonYes));
        element.click();
    }

    public String getHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> (driver.findElement(PopUpHeader).getText() != null
                && !driver.findElement(PopUpHeader).getText().isEmpty()
        ));
        return driver.findElement(PopUpHeader).getText();
    }
}