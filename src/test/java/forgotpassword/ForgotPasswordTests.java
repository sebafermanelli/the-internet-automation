package forgotpassword;

import base.BaseTests;
import com.testautomationu.pages.EmailSentPage;
import com.testautomationu.pages.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPasswordEmailSent() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("test@example.com");
        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrievePasswordButton();

        Assert.assertTrue(emailSentPage.getStatusAlert().contains("Your e-mail's been sent!"),
                "Alert text is incorrect");
    }
}
