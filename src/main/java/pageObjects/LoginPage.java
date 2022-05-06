package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(className = "pt-2 h3 heading-text")
    WebElement loginCheckText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/input")
    WebElement emailText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/input")
    WebElement passwordText;

    @FindBy(className = "btn btn-primary btn-md")
    WebElement loginButton;

    @FindBy(linkText = "Register Here")
    WebElement registerLink;

    LoginPage(WebDriver driver)
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
