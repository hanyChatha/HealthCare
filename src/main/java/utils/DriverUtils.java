package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DriverUtils {

    public void navigateToUrl(String url)
    {
        DriverFactory.driver.navigate().to(url);
    }

    public String getPageTitle()
    {
        return DriverFactory.driver.getTitle();
    }


}
