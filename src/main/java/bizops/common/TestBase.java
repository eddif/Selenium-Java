package bizops.common;

import bizops.pages.BizopsHomePage;
import bizops.pages.Login;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private static Settings settings = new Settings();
    protected WebDriver driver;
    private String environment;
    private String nodeURL;

    //PAGES
    protected Login loginPage;
    protected BizopsHomePage bizopsHomePage;




    //pages
//    protected static Login loginPage;

    @Parameters("browserType")
    @BeforeTest(alwaysRun = true)
    public void Initialize(String browser) throws MalformedURLException {


        environment = settings.getTestEnvironement();

        if (environment == "grid"){

            nodeURL = "http://192.168.10.10:5555/wd/hub";

            DesiredCapabilities caps = DesiredCapabilities.firefox();
            caps.setPlatform(Platform.MAC);
            caps.setBrowserName("firefox");
            driver = new RemoteWebDriver(new URL(nodeURL), caps);
            driver.manage().window().setSize(new Dimension(1280, 800));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(settings.getBaseUrl());
        }
        else if (environment == "dev"){
            Browser.driver = settings.getDriver();
            Browser.settings = settings;

            Browser.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            Browser.driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

            Browser.driver.get(settings.getBaseUrl());
            Browser.driver.manage().window().maximize();
        }
        else{

            String TEST_CLASSES_PATH = ".//target//test-classes";

            if (browser.equalsIgnoreCase("firefox")) {
            Browser.driver = new FirefoxDriver();
            }
            else if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", TEST_CLASSES_PATH + "//chromedriver");
                Browser.driver = new ChromeDriver();
            }

            loginPage = PageFactory.initElements(Browser.driver, Login.class);
            bizopsHomePage = PageFactory.initElements(Browser.driver, BizopsHomePage.class);

            // Maximize the browser's window
            Browser.driver.manage().window().maximize();
            Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //PropertyConfigurator.configure("log4j.properties");
            //Browser.driver.get(baseUrl);
            Browser.driver.get(settings.getBaseUrl());
        }
    }

    @AfterClass
    public static void TearDown(){
        Browser.Close();
    }
}


// BeforeSuite
// BeforeTest
// BeforeClass
// BeforeMethod

// AfterMethod
// AfterClass
// AfterTest
// AfterSuite
