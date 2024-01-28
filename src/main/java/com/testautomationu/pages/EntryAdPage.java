package com.testautomationu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryAdPage {
    private WebDriver driver;
    private By modalTitle = By.className("modal-title");
    private By closeButton = By.className("modal-footer");
    private By modal = By.id("modal");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(modal)));
    }

    public boolean modal_isDisplayed() {
        return driver.findElement(modal).isDisplayed();
    }

    public String modal_getTitle() {
        return driver.findElement(modalTitle).getText();
    }

    public void modal_clickCloseButton() {
        driver.findElement(closeButton).click();
    }
}
