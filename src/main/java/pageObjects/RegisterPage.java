package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    @FindBy(className = "pt-2 h3 heading-text")
    WebElement registerCheckText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/input")
    WebElement firstname;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/input")
    WebElement lastname;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/input")
    WebElement emailText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[4]/input")
    WebElement passwordText;

    @FindBy(className = "btn btn-primary btn-md")
    WebElement registerButton;

    @FindBy(linkText = " Login")
    WebElement loginLink;


    RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterFirstname(String fname)
    {
        firstname.sendKeys(fname);
    }

    public void enterLastname(String lname)
    {
        lastname.sendKeys(lname);
    }

    public void enterEmail(String email)
    {
        emailText.sendKeys(email);
    }

    public void enterPassword(String pwd)
    {
        passwordText.sendKeys(pwd);
    }

    public void clickRegisterButton()
    {
        registerButton.click();
    }

    public void clickLoginLink()
    {
        loginLink.click();
    }

    public String getRegisterCheckText()
    {
        return registerCheckText.getText();
    }

}
