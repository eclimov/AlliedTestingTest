import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Edik on 08.05.2017.
 */
public class Link extends Element {
    private WebDriver driver;

    public Link(WebElement element, WebDriver driver){
        super(element);
        this.driver = driver;
    }

    public Page click(){
        element.click();
        return new Page(driver);
    }
}
