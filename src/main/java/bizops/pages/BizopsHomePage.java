package bizops.pages;

import bizops.common.Browser;
import bizops.common.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by eddifey on 5/25/16.
 */
public class BizopsHomePage extends Pages {

    public boolean PageTitleIs()
    {
        return Browser.Title().contains("ALG Business Operations");
    }

    @FindBy(id = "foo" )
    WebElement foo;
}
