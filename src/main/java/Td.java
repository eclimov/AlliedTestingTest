import org.openqa.selenium.WebElement;

/**
 * Created by Edik on 08.05.2017.
 */
public class Td extends Element {
    Td(WebElement element){
        super(element);
    }

    String getContent(){
        return element.getAttribute("innerHTML");
    }

    boolean cellContains(String text){
        if(getContent().equals(text)){
            return true;
        }
        return false;
    }
}
