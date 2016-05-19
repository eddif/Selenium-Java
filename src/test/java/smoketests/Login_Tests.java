package smoketests;

import bizops.framework.Browser;
import bizops.pages.LoginPage;
import bizopstests.*;
import bizops.framework.Pages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Login_Tests extends TestBase2{

   private LoginPage loginPage;

    @Before
    public void setup(){
        Browser.Goto("/forgot_password");
        loginPage = Pages.initPage(LoginPage.class);
    }

    @Test
    public void LoginAsQA(){
        //Pages.Login().TypePassword("Foo");
        loginPage.TypePassword("Foo");

        Assert.assertTrue(true);
    }

    @After
    public void close(){
       // Use only if needed, otherwise the browser will close gracefully when all tests have been executed
       // Browser.Close();
    }

}
