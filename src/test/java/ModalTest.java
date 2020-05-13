import aquality.selenium.browser.AlertActions;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import framework.utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModalTest extends BaseTest {

    private Browser browser = AqualityServices.getBrowser();
    private String textAfterSubmitAlert1 = "You successfuly clicked an alert";
    private String textAfterSubmitAlert2 = "You clicked: Ok";
    private String randomText;
    private int sizeOfRandomString = 5;
    private String textOnFirstAlertFrame = "I am a JS Alert";
    private String textOnSecondAlertFrame = "I am a JS Confirm";
    private String textOnThirdAlertFrame = "I am a JS prompt";

    @Test
    public void testModalWindow() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Main page didn't load");
        mainPage.clickOnFirstButton();
        Assert.assertEquals(StringUtils.getTextFromAlert(), textOnFirstAlertFrame, "text on the Alert frame is wrong");
        browser.handleAlert(AlertActions.ACCEPT);
        Assert.assertEquals(textAfterSubmitAlert1, mainPage.getTextResultAlert(), "Alert message is wrong");
        mainPage.clickOnSecondButton();
        Assert.assertEquals(StringUtils.getTextFromAlert(), textOnSecondAlertFrame, "text on the Alert frame is wrong");
        browser.handleAlert(AlertActions.ACCEPT);
        Assert.assertEquals(textAfterSubmitAlert2, mainPage.getTextResultAlert(), "Alert message is wrong");
        mainPage.clickOnThirdButton();
        Assert.assertEquals(StringUtils.getTextFromAlert(), textOnThirdAlertFrame, "text on the Alert frame is wrong");
        randomText = StringUtils.getRandomText(sizeOfRandomString);
        browser.handlePromptAlert(AlertActions.ACCEPT, randomText);
        Assert.assertTrue(mainPage.getTextResultAlert().contains(randomText), "Alert message is wrong");
    }

}
