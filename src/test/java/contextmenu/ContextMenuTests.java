package contextmenu;

import base.BaseTests;
import com.testautomationu.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenu() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.contextClickBox();
        String text = contextMenuPage.alert_getText();
        contextMenuPage.alert_clickToAccept();

        Assert.assertEquals(text,
                "You selected a context menu",
                "Text incorrect");
    }
}
