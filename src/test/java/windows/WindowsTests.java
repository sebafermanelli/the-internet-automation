package windows;

import base.BaseTests;
import com.testautomationu.pages.DynamicLoadingPage1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends BaseTests {

    @Test
    public void testWindowTabs() {
        DynamicLoadingPage1 dynamicLoadingPage1 =
                homePage.clickDynamicLoading().rightClickOnElementOnPageThatIsHidden();
        getWindowManager().switchToNewTab();
        dynamicLoadingPage1.clickStart();

        Assert.assertEquals(dynamicLoadingPage1.getFinishText(),
                "Hello World!",
                "Text incorrect");
    }
}
