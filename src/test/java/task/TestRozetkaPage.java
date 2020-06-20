package task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestRozetkaPage {
    private static final int DELAY = 5;
    private static WebDriver chromeDriver;
    private RozetkaPage rozetkaPage;

    @BeforeClass
    public static void navigateChromeDriverToUrl() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
    }

    @Test
    public void checkIfTextIsPresenceOnThePage() {
        rozetkaPage = new RozetkaPage(chromeDriver);
        rozetkaPage.navigateToUrl();
        String expectedResult = "Доставка по всей Украине";
        Assert.assertTrue(rozetkaPage.textIsPresence(expectedResult), "Text isn't present on the page");
    }

    @AfterClass
    public void tearDown() {
        chromeDriver.quit();
    }
}
