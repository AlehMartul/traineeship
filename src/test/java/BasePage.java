import aquality.selenium.elements.interfaces.IElement;

public class BasePage {

    public BasePage() {
    }

    public boolean isPageLoaded(IElement element) {
        return element.state().waitForDisplayed();
    }
}