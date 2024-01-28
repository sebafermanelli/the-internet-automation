package login;

import base.BaseTests;
import com.testautomationu.pages.LoginPage;
import com.testautomationu.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        Assert.assertTrue(secureAreaPage.getStatusAlert().contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
}
