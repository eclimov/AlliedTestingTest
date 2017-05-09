import org.openqa.selenium.WebElement;

/**
 * Created by Edik on 08.05.2017.
 */
public class Element {
    protected WebElement element;

    Element(WebElement element){
        this.element = element;
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}