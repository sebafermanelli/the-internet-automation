package alerts;

import base.BaseTests;
import com.testautomationu.pages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        AlertsPage alertsPage = homePage.clickAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();

        Assert.assertEquals(alertsPage.getResult(),
                "You successfully clicked an alert",
                "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        AlertsPage alertsPage = homePage.clickAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();

        Assert.assertEquals(text,
                "I am a JS Confirm",
                "Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert() {
        AlertsPage alertsPage = homePage.clickAlerts();
        alertsPage.triggerPrompt();
        String text = "Sebastian";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();

        Assert.assertEquals(alertsPage.getResult(),
                "You entered: " + text,
                "Result text incorrect");
    }
}
