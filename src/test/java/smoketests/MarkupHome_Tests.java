package smoketests;

import bizops.common.Browser;
import bizops.common.Pages;
import bizops.common.TestBase;
import bizops.pages.Login;
import bizops.pages.MarkupHome;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class MarkupHome_Tests extends TestBase {

    private Login loginPage;

    private MarkupHome markupHomePage;

    @Before
    public void setup(){

        // initial test suite setup

        Browser.Goto("login/home");
        Browser.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // initiate pages to be used in all tests

        loginPage = Pages.initPage(Login.class);
        markupHomePage = Pages.initPage(MarkupHome.class);

        loginPage.LoginInAs("qa", "test");

    }

    @Test
    public void VerifyDefaultMarkupValuesAreSaved(){

        Browser.Goto("markup");

        //Create new Default Markup
        markupHomePage.ClickDefaultMarkupSettingsLink();
        markupHomePage.SelectBrandRadioButton("Travel Impressions");
       // markupHomePage.SelectAdditionalPercentageRadioButton();
        markupHomePage.SelectProfitMarginRadioButton();
        markupHomePage.EnterGlobalMarkupAmount("199");
        markupHomePage.SelectCurrency("MXN");
        markupHomePage.save_button.click();

        //Assert.assertTrue(markupHomePage.PageTitleIs());

        // Verify Default Markup Values are Saved

        markupHomePage.ClickDefaultMarkupSettingsLink();
        markupHomePage.SelectBrandRadioButton("Travel Impressions");

        Assert.assertTrue(markupHomePage.markup_type_margin_radio_button.isSelected());
        Assert.assertTrue(markupHomePage.markup_value_textbox.getAttribute("value").contains("199"));
        Assert.assertTrue(markupHomePage.currency_dropdown.isEnabled());

        markupHomePage.cancel_button.click();

    }

    @After
    public void close(){

        // Use only if needed, otherwise the browser will close gracefully when all tests suites/classes have been executed
        Browser.Close();

    }

}
