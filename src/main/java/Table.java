import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edik on 08.05.2017.
 */
public class Table extends Element {
    private WebElement tableHead;
    private List<Thr> thr = new ArrayList<Thr>();
    private WebElement tableBody;
    private List<Tr> tr = new ArrayList<Tr>();

    Table(WebElement element){
        super(element);
        WebElement tableHead = element.findElement(By.tagName("thead"));
        List<WebElement> headRows = tableHead.findElements(By.tagName("tr"));
        for (WebElement headRow: headRows) {
            thr.add(new Thr(headRow));
        }

        WebElement tableBody = element.findElement(By.tagName("tbody"));
        List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));
        for (WebElement tableRow: tableRows) {
            tr.add(new Tr(tableRow));
        }
    }

    boolean languageExists(String text){
        for (Tr tableRow: tr) {
            if(tableRow.getCells().get(0).cellContains(text)){
                return true;
            }
        }
        return false;
    }

    public void printTwoColumns(){
        System.out.println();
        for (Tr tableHeaderRow: thr) {
            System.out.println(tableHeaderRow.getFormattedRow());
        }
        for (Tr tableRow: tr) {
            System.out.println(tableRow.getFormattedRow());
        }
    }
}
