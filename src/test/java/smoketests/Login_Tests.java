package smoketests;

import bizops.common.Browser;
import bizops.common.TestBase;
import bizops.pages.BizopsHomePage;
import bizops.pages.Login;
import bizops.common.Pages;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class Login_Tests extends TestBase{

    @BeforeClass
    public void Initialize() throws MalformedURLException{

    }

    @Test
    public void LoginAsQA1(){
        Browser.SleepFor(5000);
        loginPage.LoginInAs("qa", "test");
        Browser.SleepFor(5000);
        assertTrue(bizopsHomePage.PageTitleIs());
    }

//    @Test
//    public void LoginAsQA2(){
//        Browser.SleepFor(5000);
//        loginPage.LoginInAs("qa", "test");
//        Browser.SleepFor(5000);
//        assertTrue(bizopsHomePage.PageTitleIs());
//    }

    @AfterClass public void close(){

    }

}
