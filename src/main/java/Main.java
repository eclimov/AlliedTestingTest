import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Edik on 08.05.2017.
 */
@Listeners({TL.class})
public class Main{
    @DataProvider(name = "languagesToSearch")
    public Object[][] createData1() {
        return new Object[][] {
                { "Python"}  //positive
                //,{ "C++"} //negative
        };
    }

    @Test(dataProvider = "languagesToSearch")
    public void searchLanguage(String language) throws InterruptedException {
        Reporter.log(language);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.bing.com/");

        SearchPage SearchPage = new SearchPage(driver);

        SearchResultsPage results = SearchPage.search("Selenium");

        Page result = results.goToResultPage("www.seleniumhq.org/download");

        result.getFirstTable().printTwoColumns();

        Assert.assertTrue(result.getFirstTable().languageExists(language), "There is no "+language+" language in the list");

        //Thread.sleep(2000);
        driver.quit();
    }
}
