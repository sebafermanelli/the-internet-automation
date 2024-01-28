package hover;

import base.BaseTests;
import com.testautomationu.pages.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1() {
        HoversPage hoversPage = homePage.clickHovers();
        HoversPage.FigureCaption figureCaption = hoversPage.hoverOverFigure(1);

        Assert.assertTrue(figureCaption.isCaptionDispleyed(),
                "Figure caption is not displayed");
        Assert.assertEquals(figureCaption.getTitle(),
                "name: user1",
                "Caption title incorrect");
        Assert.assertEquals(figureCaption.getLinkText(),
                "View profile",
                "Caption link text incorrect");
        Assert.assertTrue(figureCaption.getLink().endsWith("/users/1"),
                "Link incorrect");
    }
}
