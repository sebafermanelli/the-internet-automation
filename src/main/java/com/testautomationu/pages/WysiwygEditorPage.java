package com.testautomationu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WysiwygEditorPage {
    private WebDriver driver;
    private By frame = By.id("mce_0_ifr");
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.xpath(".//button[@aria-label='Decrease indent']");
    private By increaseIndentButton = By.xpath(".//button[@aria-label='Increase indent']");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTextArea() {
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor() {
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void decreaseIndention() {
        driver.findElement(decreaseIndentButton).click();
    }

    public void increaseIndention() {
        driver.findElement(increaseIndentButton).click();
    }

    private void switchToEditArea() {
        WebElement frameElement = driver.findElement(frame);
        driver.switchTo().frame(frameElement);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
}
