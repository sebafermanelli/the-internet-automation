package entryad;

import base.BaseTests;
import com.testautomationu.pages.EntryAdPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EntryAdTests extends BaseTests {

    @Test
    public void testCloseModal() {
        EntryAdPage entryAdPage = homePage.clickEntryAd();
        String title = entryAdPage.modal_getTitle();
        entryAdPage.modal_clickCloseButton();

        Assert.assertEquals(title,
                "THIS IS A MODAL WINDOW",
                "Title incorrect");
        Assert.assertFalse(entryAdPage.modal_isDisplayed(),
                "Modal displayed");
    }
}
