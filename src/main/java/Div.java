import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Edik on 08.05.2017.
 */
public class Div extends Element {
    Div(WebElement element){
        super(element);
    }

    boolean linkExists(String url){
        return !element.findElements(By.cssSelector("a[href*='"+url+"']")).isEmpty();
    }
}
