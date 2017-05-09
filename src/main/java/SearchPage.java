import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Edik on 08.05.2017.
 */
public class SearchPage extends Page {

    @FindBy(name = "q")
    private TextInput searchField = new TextInput(driver.findElement(By.name("q")));

    SearchPage(WebDriver driver){
        super(driver);
    }

    public SearchResultsPage search(String text) {
        searchField.insert(text);
        searchField.submit();
        return new SearchResultsPage(driver);
    }


}
