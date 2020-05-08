import aquality.selenium.browser.AlertActions;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import framework.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalTest {

    private Browser browser = AqualityServices.getBrowser();
    private String textAfterSubmitAlert1 = "You successfuly clicked an alert";
    private String textAfterSubmitAlert2 = "You clicked: Ok";
    private String randomText;
    private String mainURL = "http://the-internet.herokuapp.com/javascript_alerts";
    private int sizeOfRandomString = 5;

    @BeforeMethod
    public void createDriver() {
        browser.maximize();
        browser.goTo(mainURL);
    }

    @Test
    public void ModalWindowTest() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Main page didn't load");
        mainPage.clickOnFirstButton();
        browser.handleAlert(AlertActions.ACCEPT);
        Assert.assertTrue(mainPage.getTextFromAlert().equals(textAfterSubmitAlert1), "Alert message is wrong");
        mainPage.clickOnSecondButton();
        browser.handleAlert(AlertActions.ACCEPT);
        Assert.assertTrue(mainPage.getTextFromAlert().equals(textAfterSubmitAlert2), "Alert message is wrong");
        mainPage.clickOnThirdButton();
        randomText = new Utils().getRandomText(sizeOfRandomString);
        browser.handlePromptAlert(AlertActions.ACCEPT, randomText);
        Assert.assertTrue(mainPage.getTextFromAlert().contains(randomText), "Alert message is wrong");
    }

    @AfterMethod
    public void driverQuit() {
        browser.quit();
    }

}
