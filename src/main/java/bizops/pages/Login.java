package bizops.pages;


import bizops.common.Browser;
import bizops.common.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login extends Pages {


    private WebDriver driver;

    // Locators

    @FindBy(id = "input_username" )
    @CacheLookup
    WebElement username_field;

    @FindBy(id = "input_password")
    @CacheLookup
    WebElement password_field;

    @FindBy(id = "button_submit")
    @CacheLookup
    WebElement login_button;

    public void LoginInAs(String _username, String _password){
        ClearLoginFields();
        TypeUserName(_username);
        TypePassword(_password);
        ClickLoginButton();
    }

    public void TypeUserName(String _username){
        username_field.sendKeys(_username);
    }

    public void TypePassword(String _password){
        password_field.sendKeys(_password);
    }

    public void ClickLoginButton(){
        login_button.click();

    }

    public void ClearLoginFields(){
        username_field.clear();
        password_field.clear();
    }

}
