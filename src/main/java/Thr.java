import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edik on 08.05.2017.
 */
public class Thr extends Tr{
    private List<Td> td = new ArrayList<Td>();

    Thr(WebElement element){
        super(element);
        init("th");
    }

}