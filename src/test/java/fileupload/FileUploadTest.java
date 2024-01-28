package fileupload;

import base.BaseTests;
import com.testautomationu.pages.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadPage fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("C:/Users/Sebastian/workspace/the-internet-automation/resources/chromedriver.exe");
        String files = fileUploadPage.getUploadedFiles();

        Assert.assertEquals(files,
                "chromedriver.exe",
                "File incorrect");
    }
}
