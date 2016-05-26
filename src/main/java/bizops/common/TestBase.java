package bizops.common;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private static Settings settings = new Settings();

    @BeforeClass
    public static void Initialize(){

        // Browser.Initialize();

        Browser.driver = settings.getDriver();
        Browser.settings = settings;

        Browser.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Browser.driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        Browser.driver.get(settings.getBaseUrl());
        Browser.driver.manage().window().maximize();

    }

    @AfterClass
    public static void TearDown(){
        Browser.Close();
    }
}
