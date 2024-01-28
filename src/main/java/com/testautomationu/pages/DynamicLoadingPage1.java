package com.testautomationu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage1 {
    private WebDriver driver;
    private By startButton = By.xpath("//div[@id='start']/button");
    private By loadingSlider = By.id("loading");
    private By resultText = By.id("finish");

    public DynamicLoadingPage1(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
//        With WebDriver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingSlider)));

//        With Fluent wait
//        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(NoSuchElementException.class);
//        fluentWait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingSlider)));
    }

    public String getFinishText() {
        return driver.findElement(resultText).getText();
    }
}
