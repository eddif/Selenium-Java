package bizops.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public abstract class Extensions {

    private WebDriver driver;

    public String getAttributeValue(By by) //48 usages
    {
        return driver.findElement(by).getAttribute("value");
    }

    public String getAttributeValue(WebElement element)
    {
        return element.getAttribute("value");
    }

    public void DragAndDrop(WebElement from_element, WebElement to_element)
    {
        Actions builder = new Actions(driver);

        Action dragAndDrop = builder.clickAndHold(from_element)
                .moveToElement(to_element)
                .release(to_element)
                .build();

        dragAndDrop.perform();
    }

}
