package smoketests;

import bizops.common.Browser;
import bizops.common.TestBase;
import bizops.pages.BizopsHomePage;
import bizops.pages.Login;
import bizops.common.Pages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


public class Login_Tests extends TestBase{

   private Login loginPage;

    private BizopsHomePage bizopsHomePage;

    @Before
    public void setup(){

        // initial test suite setup

        Browser.Goto("login/home");
        Browser.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // initiate pages to be used in all tests

        loginPage = Pages.initPage(Login.class);
        bizopsHomePage = Pages.initPage(BizopsHomePage.class);

    }

    @Test
    public void LoginAsQA(){

        loginPage.LoginInAs("qa", "test");

        Assert.assertTrue(bizopsHomePage.PageTitleIs());
    }

    @After
    public void close(){

       // Use only if needed, otherwise the browser will close gracefully when all tests suites/classes have been executed
        Browser.Close();

    }

}
