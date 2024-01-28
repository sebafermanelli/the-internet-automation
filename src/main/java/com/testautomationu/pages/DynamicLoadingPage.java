package com.testautomationu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public DynamicLoadingPage1 clickElementOnPageThatIsHidden() {
        clickLink("Example 1: Element on page that is hidden");
        return new DynamicLoadingPage1(driver);
    }

    public DynamicLoadingPage1 rightClickOnElementOnPageThatIsHidden() {
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).sendKeys(Keys.CONTROL, Keys.RETURN);
        return new DynamicLoadingPage1(driver);
    }

    public DynamicLoadingPage2 clickElementRenderedAfterTheFact() {
        clickLink("Example 2: Element rendered after the fact");
        return new DynamicLoadingPage2(driver);
    }

    public DynamicLoadingPage2 rightClickOnElementRenderedAfterTheFact() {
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).sendKeys(Keys.CONTROL, Keys.RETURN);
        return new DynamicLoadingPage2(driver);
    }
}
