import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import org.openqa.selenium.By;



public class MainPage {

    private By jsAlert = By.xpath(".//button[@onclick='jsAlert()']");
    private By jsConfirm = By.xpath(".//button[@onclick='jsConfirm()']");
    private By jsPrompt = By.xpath(".//button[@onclick='jsPrompt()']");
    private By textAfterSubmitAlert = By.xpath(".//p[@id='result']");


    public void clickOnFirstButton() {
       AqualityServices.getElementFactory().getButton(jsAlert, "Js alert").click();
    }

    public void clickOnSecondButton() {
        AqualityServices.getElementFactory().getButton(jsConfirm, "Js Confirm").click();

    }

    public void clickOnThirdButton() {
        AqualityServices.getElementFactory().getButton(jsPrompt, "Js Prompt").click();
    }

    public String getTextFromAlert() {
        String alertText = AqualityServices.getElementFactory().getLabel(textAfterSubmitAlert, "text").getText();
        return alertText;
    }

    public boolean isMainPageLoaded() {
        return AqualityServices.getElementFactory().getButton(jsAlert, "js alert", ElementState.DISPLAYED)
                .state().waitForDisplayed();
    }

}
