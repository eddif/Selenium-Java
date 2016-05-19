package bizopstests;

import bizops.framework.Browser;
import bizops.framework.Settings;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Created by Eddi Fey on 5/18/2016.
 */
public class TestBase2 {

    private static Settings settings = new Settings();

    @BeforeClass
    public static void Initialize(){
       // Browser.Initialize();
        Browser.driver = settings.getDriver();
        Browser.settings = settings;
        Browser.driver.get(settings.getBaseUrl());
        Browser.driver.manage().window().maximize();
    }

    @AfterClass
    public static void TearDown(){
        Browser.Close();
    }
}
