import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Edik on 08.05.2017.
 */
public class Page {
    private String url;
    protected WebDriver driver;

    Page(WebDriver driver){
        this.url = driver.getCurrentUrl();
        this.driver = driver;
    }

    WebElement setInput(By by){
        return driver.findElement(by);
    }

    boolean tableExists(){
        return !driver.findElements(By.tagName("table")).isEmpty();
    }

    Table getFirstTable(){
        return new Table(driver.findElement(By.tagName("table")));
    }
}
