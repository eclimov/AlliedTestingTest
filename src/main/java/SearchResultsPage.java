import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edik on 08.05.2017.
 */
public class SearchResultsPage extends Page {

    SearchResultsPage(WebDriver driver){
        super(driver);
    }

    //Bing uses "b_algo" class name for each resulting element
    public List<Div> getResultDivs(){
        List<WebElement> results = driver.findElements(By.cssSelector("li[class='b_algo']"));
        List<Div> resultDivs = new ArrayList<Div>();
        for (WebElement res: results) {
            resultDivs.add(new Div(res));
        }
        return resultDivs;
    }

    public Page goToResultPage(String url){
        List<Div> resultDivs = getResultDivs();
        for (Div div : resultDivs) {
            if(div.linkExists(url)){
                Link link = new Link(driver.findElement(By.cssSelector("a[href*='"+url+"']")), driver);
                return link.click();
            }
        }
        return new Page(driver);
    }
}
