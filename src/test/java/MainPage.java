import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class MainPage extends BasePage{

    private ILabel textAfterSubmitAlert = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//p[@id='result']"), "textAfterSubmitAlert");
    private IButton jsAlert = AqualityServices.getElementFactory()
            .getButton(By.xpath("//button[@onclick='jsAlert()']"), "jsAlert");
    private IButton jsConfirm = AqualityServices.getElementFactory()
            .getButton(By.xpath("//button[@onclick='jsConfirm()']"), "jsAlert");
    private IButton jsPrompt = AqualityServices.getElementFactory()
            .getButton(By.xpath("//button[@onclick='jsPrompt()']"), "jsAlert");

    public void clickOnFirstButton() {
        jsAlert.click();
    }

    public void clickOnSecondButton() {
        jsConfirm.click();
    }

    public void clickOnThirdButton() {
        jsPrompt.click();
    }

    public String getTextResultAlert() {
        String alertText = textAfterSubmitAlert.getText();
        return alertText;
    }

    public boolean isMainPageLoaded() {
        return isPageLoaded(jsAlert);
    }
}
