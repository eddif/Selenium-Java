package bizops.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.internal.Streams;

public class Browser {

    public static WebDriver driver;
    public static Settings settings;

    //private static String PAGE_URL = "http://the-internet.herokuapp.com";
    //public static WebDriver driver = settings.getDriver();

    public Browser(WebDriver driver){
       // WebDriver = driver;
    }

    public static void Initialize() {
        Goto("");
    }

    public static void Goto(String url) {
        driver.get(settings.getBaseUrl() + url);
    }

    public static void Close(){
        driver.quit();
    }

//    public static void Title() {
//        driver.getTitle();
//    }

    public static String Title(){
        return driver.getTitle();
    }


    public static void SwitchToWindow(String windowname) {
        driver.switchTo().window(windowname);
    }

    public static void SwitchToFrame(String framename) {
        driver.switchTo().window(framename);
    }

    public static void ClickHistoryBackButton(){
        driver.navigate().back();
    }

    public static void ClickHistoryForwardButton(){
        driver.navigate().forward();
    }

    public static void WaitForElementToShow(int seconds){

    }

    public static void SleepFor(int i){
        try {
            Thread.sleep(i);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
