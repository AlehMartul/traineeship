import aquality.selenium.browser.AlertActions;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import framework.utils.ReadPropertyTool;
import framework.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ModalTest extends BaseTest {

    private Browser browser = AqualityServices.getBrowser();
    private static final String TEXT_AFTER_SUBMIT_ALERT1 = "You successfuly clicked an alert";
    private static final String TEXT_AFTER_SUBMIT_ALERT2 = "You clicked: Ok";
    private String randomText;
    private int sizeOfRandomString = 5;
    private static final String TEXT_ON_FIRST_ALERT_FRAME = "I am a JS Alert";
    private static final String TEXT_ON_SECOND_ALERT_FRAME = "I am a JS Confirm";
    private static final String TEXT_ON_THIRD_ALERT_FRAME = "I am a JS prompt";

    @Test
    public void testModalWindow() throws IOException {
        MainPage mainPage = new MainPage();
        String myURL = System.getProperty("mainUrl");
        AqualityServices.getLogger().info(myURL);
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Main page didn't load");
        mainPage.clickOnFirstButton();
        Assert.assertEquals(StringUtils.getTextFromAlert(), TEXT_ON_FIRST_ALERT_FRAME, "text on the Alert frame is wrong");
        browser.handleAlert(AlertActions.ACCEPT);
        Assert.assertEquals(TEXT_AFTER_SUBMIT_ALERT1, mainPage.getTextResultAlert(), "Alert message is wrong");
        mainPage.clickOnSecondButton();
        Assert.assertEquals(StringUtils.getTextFromAlert(), TEXT_ON_SECOND_ALERT_FRAME, "text on the Alert frame is wrong");
        browser.handleAlert(AlertActions.ACCEPT);
        Assert.assertEquals(TEXT_AFTER_SUBMIT_ALERT2, mainPage.getTextResultAlert(), "Alert message is wrong");
        mainPage.clickOnThirdButton();

        Assert.assertEquals(StringUtils.getTextFromAlert(), TEXT_ON_THIRD_ALERT_FRAME, "text on the Alert frame is wrong");
        randomText = StringUtils.getRandomText(sizeOfRandomString);
        browser.handlePromptAlert(AlertActions.ACCEPT, randomText);
        Assert.assertTrue(mainPage.getTextResultAlert().contains(randomText), "Alert message is wrong");
    }
}
