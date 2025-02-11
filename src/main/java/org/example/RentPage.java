package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    private final WebDriver driver;
    private final By startDateRent = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By periodRent = By.className("Dropdown-control");
    private final By selectPeriodRent = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
    private final By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By previousButton = By.xpath("Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i");
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By acceptOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private final By modalWindow = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputStartDateRent(String startDate) {
        driver.findElement(startDateRent).sendKeys(startDate);
        driver.findElement(startDateRent).sendKeys(Keys.ENTER);
    }


    public void choicePeriodRent() {
        driver.findElement(periodRent).click();
        driver.findElement(selectPeriodRent).click();
    }


    public void choiceColourBlack() {
        driver.findElement(checkBoxColourBlackPearl).click();
    }


    public void inputComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }


    public void pushOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void pushAcceptOrderButton() {
        driver.findElement(acceptOrderButton).click();
    }

    public boolean checkModalWindowEnabled() {
        return driver.findElement(acceptOrderButton).isDisplayed();
    }

    public void rent(String startDate, String comment) {
        inputStartDateRent(startDate);
        choicePeriodRent();
        choiceColourBlack();
        inputComment(comment);
        pushOrderButton();
        pushAcceptOrderButton();
    }
}