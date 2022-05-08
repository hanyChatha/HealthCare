package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(className = "heading-text")
    public WebElement loginCheckText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/input")
    public WebElement emailText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/input")
    public WebElement passwordText;

    @FindBy(className = "btn-primary")
    public WebElement loginButton;

    @FindBy(linkText = "Register Here")
    public WebElement registerLink;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickLoginButton()
    {
        loginButton.click();
    }

    public void clickRegisterLink()
    {
        registerLink.click();
    }

    public void enterEmail(String email)
    {
        emailText.sendKeys(email);
    }

    public void enterPassword(String pwd)
    {
        passwordText.sendKeys(pwd);
    }

    public String getLoginText()
    {
        return loginCheckText.getText();
    }

}
