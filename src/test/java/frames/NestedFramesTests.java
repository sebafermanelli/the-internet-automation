package frames;

import base.BaseTests;
import com.testautomationu.pages.NestedFramesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFramesTests extends BaseTests {

    @Test
    public void testLeftFrame() {
        NestedFramesPage nestedFramesPage = homePage.clickFrames().clickNestedFrames();

        Assert.assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Text incorrect");
        Assert.assertEquals(nestedFramesPage.getMiddleFrameText(), "MIDDLE", "Text incorrect");
        Assert.assertEquals(nestedFramesPage.getRightFrameText(), "RIGHT", "Text incorrect");
        Assert.assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Text incorrect");
    }
}
