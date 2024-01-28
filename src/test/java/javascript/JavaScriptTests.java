package javascript;

import base.BaseTests;
import com.testautomationu.pages.DropdownPage;
import com.testautomationu.pages.InfiniteScrollPage;
import com.testautomationu.pages.LargeAndDeepDomPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph() {
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(5);
    }

    @Test
    public void testSelectMultipleOptions() {
        DropdownPage dropdownPage = homePage.clickDropdown();
        dropdownPage.addMultipleSelector();

        List<String> optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectFromDropdown);

        Assert.assertTrue(dropdownPage.getSelectedOptions().containsAll(optionsToSelect),
                "All options were not selected");
        Assert.assertEquals(dropdownPage.getSelectedOptions().size(),
                optionsToSelect.size(),
                "Incorrect number of selected options");
    }
}
