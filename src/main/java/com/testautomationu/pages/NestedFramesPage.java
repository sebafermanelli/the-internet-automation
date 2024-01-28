package com.testautomationu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String middleFrame = "frame-middle";
    private String rightFrame = "frame-right";
    private String bottomFrame = "frame-bottom";
    private By body = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFrameText() {
        return driver.findElement(body).getText();
    }

    public String getLeftFrameText() {
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); // Exit left to top frame
        driver.switchTo().parentFrame(); // Exit top to main frame
        return text;
    }

    public String getMiddleFrameText() {
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(middleFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); // Exit middle to top frame
        driver.switchTo().parentFrame(); // Exit top to main frame
        return text;
    }

    public String getRightFrameText() {
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(rightFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); // Exit right to top frame
        driver.switchTo().parentFrame(); // Exit top to main frame
        return text;
    }

    public String getBottomFrameText() {
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame(); // Exit bottom to main frame
        return text;
    }
}
