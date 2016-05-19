package bizops.pages;


import bizops.framework.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Pages {


    private WebDriver driver;

    // Locators
    @FindBy(how = How.ID, using = "user_name" )
    WebElement username;

    @FindBy(how = How.ID, using = "email")
    WebElement email;

    public void ClickLoginButton(){
        username.click();
    }

    public void TypePassword(String _password){
        email.sendKeys(_password);
    }







}
