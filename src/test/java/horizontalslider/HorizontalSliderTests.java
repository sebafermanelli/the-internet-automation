package horizontalslider;

import base.BaseTests;
import com.testautomationu.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testRange4() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.setSlider("4");

        Assert.assertEquals(horizontalSliderPage.getSliderResult(), "4", "Range incorrect");
    }
}
