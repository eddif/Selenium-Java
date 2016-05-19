package bizops.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

    public static WebDriver driver;
    public static Settings settings;

    //private static String PAGE_URL = "http://the-internet.herokuapp.com";
    //public static WebDriver driver = settings.getDriver();

    public Browser(WebDriver driver){
       // WebDriver = driver;
    }

    public static void Initialize()
    {
        Goto("");
    }

    public static void Goto(String url)
    {
        //driver.navigate().to(PAGE_URL + url);
        driver.get(settings.getBaseUrl() + url);
    }

    public static void Close(){
        driver.close();
    }

}
