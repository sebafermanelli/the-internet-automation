package frames;

import base.BaseTests;
import com.testautomationu.pages.WysiwygEditorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WysiwygEditorTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        WysiwygEditorPage wysiwygEditorPage = homePage.clickWysiwygEditor();
        String text1 = "Sebastian ";
        String text2 = "Fermanelli";
        wysiwygEditorPage.clearTextArea();
        wysiwygEditorPage.setTextArea(text1);
        wysiwygEditorPage.decreaseIndention();
        wysiwygEditorPage.setTextArea(text2);

        Assert.assertEquals(wysiwygEditorPage.getTextFromEditor(),
                text1 + text2,
                "Text from editor is incorrect");
    }
}
