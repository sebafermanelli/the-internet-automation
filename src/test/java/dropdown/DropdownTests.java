package dropdown;

import base.BaseTests;
import com.testautomationu.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        DropdownPage dropdownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        List<String> selectedOptions = dropdownPage.getSelectedOptions();

        Assert.assertEquals(selectedOptions.size(), 1, "Incorrect number of selected options");
        Assert.assertTrue(selectedOptions.contains(option), "Incorrect option");
    }
}
