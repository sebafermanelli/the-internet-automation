package keypresses;

import base.BaseTests;
import com.testautomationu.pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends BaseTests {

    @Test
    public void testShift() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("Hi!" + Keys.SHIFT);

        Assert.assertEquals(keyPressesPage.getResult(), "You entered: SHIFT", "The key pressed is incorrect");
    }

    @Test
    public void testPi() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterPi();
    }
}
