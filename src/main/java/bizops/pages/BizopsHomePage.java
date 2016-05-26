package bizops.pages;

import bizops.common.Browser;
import bizops.common.Pages;

/**
 * Created by eddifey on 5/25/16.
 */
public class BizopsHomePage extends Pages {

    public boolean PageTitleIs()
    {
        return Browser.Title().contains("ALG Business Operations");
    }
}
