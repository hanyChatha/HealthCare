package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(linkText = "Log out")
    WebElement logoutLink;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log In")
    WebElement loginLink;


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickRegisterLink()
    {
        registerLink.click();
    }

    public void clickLoginLink()
    {
        loginLink.click();
    }

    public boolean verifyLogout()
    {
        return logoutLink.isDisplayed();
    }
}
