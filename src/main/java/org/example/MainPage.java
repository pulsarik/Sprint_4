package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    private WebDriver driver;

    private By headerOrderButton = By.className("Button_Button__ra12g");

    private final By orderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");


    public static final String[] questionArrayButtons = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    public static final String[] textQuestionsAboutImportant = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void pushHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    public void pushOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void scrollToPushOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        System.out.println("Найденный элемент: " + element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollPageToQuestionsAboutImportant() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lastQuestionArrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(questionArrayButtons[7])));
        System.out.println("Найденный элемент: " + lastQuestionArrow);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
    }

    public void pushQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
    }
}