package dynamicloading;

import base.BaseTests;
import com.testautomationu.pages.DynamicLoadingPage1;
import com.testautomationu.pages.DynamicLoadingPage2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTests extends BaseTests {

    @Test
    public void testWaitUntilHidden() {
        DynamicLoadingPage1 dynamicLoadingPage1 = homePage.clickDynamicLoading().clickElementOnPageThatIsHidden();
        dynamicLoadingPage1.clickStart();

        Assert.assertEquals(dynamicLoadingPage1.getFinishText(),
                "Hello World!",
                "Text incorrect");
    }

    @Test
    public void testWaitUntilElementRendered() {
        DynamicLoadingPage2 dynamicLoadingPage2 = homePage.clickDynamicLoading().clickElementRenderedAfterTheFact();
        dynamicLoadingPage2.clickStart();

        Assert.assertFalse(dynamicLoadingPage2.isStartButtonDisplayed(),
                "Start button displayed");
        Assert.assertEquals(dynamicLoadingPage2.getFinishText(),
                "Hello World!",
                "Text incorrect");
    }
}
