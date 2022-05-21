package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    @FindBy(linkText = "Log out")
    public WebElement logoutButton;

    @FindBy(linkText = "Register")
    public WebElement registerLink;

    @FindBy(linkText = "Log In")
    public WebElement loginLink;


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


    public boolean logoutButtonCheck()
    {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        return logoutButton.isDisplayed();
    }
}
