import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edik on 08.05.2017.
 */
public class Tr extends Element{
    private List<Td> td = new ArrayList<Td>();

    Tr(WebElement element){
        super(element);
        init("td");
    }

    public List<Td> getCells() {
        return td;
    }

    protected void init(String tagName){
        List<WebElement> tableCells = element.findElements(By.tagName(tagName));
        for (WebElement tableCell: tableCells) {
            td.add(new Td(tableCell));
        }
    }

    protected String getFormattedRow(){
        String result = "";
        String format = "%-20s%s%n";
        System.out.printf(format, td.get(0).getContent(), td.get(1).getContent());
        return result;
    }
}
