package com.testautomationu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderInput = By.cssSelector(".sliderContainer input");
    private By sliderResult = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSlider(String value) {
        while (!getSliderResult().equals(value)) {
            driver.findElement(sliderInput).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderResult() {
        return driver.findElement(sliderResult).getText();
    }
}
