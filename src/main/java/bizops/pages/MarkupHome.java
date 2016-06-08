package bizops.pages;

import bizops.common.Browser;
import bizops.common.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MarkupHome extends Pages {

    private WebDriver driver;

    //<editor-fold desc="Locators">

    @FindBy(id = "btn_add_markup" )
    WebElement add_markupup_glyph_icon;

    @FindBy(linkText = "Default Markup Settings")
    WebElement default_markup_settings_link;


    //default setting modal window
    @FindBy(id = "markupBrandModal")
    WebElement default_markup_window;

    @FindBy(name = "markupBrand.brandId")
    List<WebElement> brand_radio_buttons;

    @FindBy(id = "markupTypeAdd")
    public WebElement markup_type_add_radio_button;

    @FindBy(id = "markupTypeMargin")
    public WebElement markup_type_margin_radio_button;

    @FindBy(id = "input_markup_amount")
    public WebElement markup_value_textbox;

    @FindBy(id = "select_currency")
    public WebElement currency_dropdown;

    @FindBy(id = "save_button")
    public WebElement save_button;

    @FindBy(id = "cancel_button")
    public WebElement cancel_button;

    @FindBy(id = "tbl_curr_markup")
    WebElement current_approved_markup_table;



    //</editor-fold>

    //<editor-fold desc="Methods">

    public boolean PageTitleIs()
    {
       return Browser.Title().contains("Markups");
    }

    public void ClickAddNewMarkupIcon(){

        add_markupup_glyph_icon.click();
    }

    public void ClickDefaultMarkupSettingsLink(){

        default_markup_settings_link.click();
    }

    public void SetDefaultMarkupSettings(String brandname, String markupmethod, int markupamount, String currency){


    }

    public void SelectBrand(String brandname) {

        String brandkey = "";

        // temp: hardcode brands as there is no option to select the innerHtml of a input radio button
        // this would be easy solved if the value attribute containing the text value, but it's stored as an id
        // may add help class to reuse if unable to fix code
        HashMap<Integer, String> brandIdtoNameMapping = new HashMap<Integer, String>();
        brandIdtoNameMapping.put(1, "Apple Vacations");
        brandIdtoNameMapping.put(2, "Travel Impressions");
        brandIdtoNameMapping.put(3, "Cheap Caribbean");
        brandIdtoNameMapping.put(4, "Apple Leisure Group");
        brandIdtoNameMapping.put(120, "Brand X");
        brandIdtoNameMapping.put(121, "Brand Q");

        for (Map.Entry<Integer, String> entry : brandIdtoNameMapping.entrySet()) {
            if (entry.getValue().equals(brandname)) {
            brandkey = Integer.toString(entry.getKey()); //convert to string for selenium getAttribute() method
                break;
            }
        }

        for (WebElement radio : brand_radio_buttons) {
            if (radio.getAttribute("value").equals(brandkey)) { //getText() is retrieving the text from the value attribute
                radio.click();
                break;
            }
        }

    }

    public void SelectAdditionalPercentageRadioButton(){
        markup_type_add_radio_button.click();
    }

    public void SelectProfitMargin(){
        markup_type_margin_radio_button.click();
    }

    public void EnterGlobalMarkupAmount(String percent_value){
        markup_value_textbox.clear();
        markup_value_textbox.sendKeys(percent_value);
    }

    public void SelectCurrency(String country_value){
        getCurrencyDropdownOptions().selectByVisibleText(country_value);
    }

    Select getCurrencyDropdownOptions(){
        return new Select(currency_dropdown);
    }

    //</editor-fold>


}


