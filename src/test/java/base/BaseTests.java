package base;

import com.testautomationu.pages.HomePage;
import com.testautomationu.utils.CookieManager;
import com.testautomationu.utils.EventReporter;
import com.testautomationu.utils.WindowManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(), new File("resources/screenshots/" + result.getName() + ".png").toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    public CookieManager getCookieManager() {
        return new CookieManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
//        options.addArguments("headless");
        return options;
    }
}
