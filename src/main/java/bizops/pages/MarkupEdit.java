package bizops.pages;

import bizops.common.Browser;
import bizops.common.Pages;

public class MarkupEdit extends Pages {




    public boolean PageTitleIs()
    {
        return Browser.Title().contains("Markups");
    }
}
