package cookie;

import base.BaseTests;
import com.testautomationu.utils.CookieManager;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookieTests extends BaseTests {

    @Test
    public void testAddAdminIdCookie() {
        CookieManager cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie("admin_id", "1");
        cookieManager.addCookie(cookie);
    }

    @Test
    public void testDeleteOptimizelyBucketsCookie() {
        CookieManager cookieManager = getCookieManager();
        String cookieName = "optimizelyBuckets";
        Cookie cookie = cookieManager.getCookie(cookieName);
        cookieManager.deleteCookie(cookie);

        Assert.assertFalse(cookieManager.isCookiePresent(cookie),
                "Cookie " + cookieName + " exists");
    }
}
