import org.openqa.selenium.WebElement;

/**
 * Created by Edik on 08.05.2017.
 */
public class TextInput extends Element {

    TextInput(WebElement element){
        super(element);
    }

    public void insert(String text) {
        element.sendKeys(text);
    }

    public String getValue(){
        return element.getAttribute("value");
    }

    public void submit(){
        element.submit();
    }
}
