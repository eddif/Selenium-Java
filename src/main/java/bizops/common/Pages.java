package bizops.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    public static WebDriver driver;


    public static <T extends Pages> T initPage(Class<T> pageClass) {
        return PageFactory.initElements(Browser.driver, pageClass);
    }

    // You could instantiate pages here, but would use multiple calls - best to use test @before method

//    public static LoginPage Login(){
//        return Pages.initPage(LoginPage.class);
//    }

}
