package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    @FindBy (className = "Toastify__zoom-enter")
    public WebElement toastMessage;

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

    public String getWrongPasswordMessage()
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.driver,15);
        toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']/div[2]")));
        //DriverFactory.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);  //*[@id="2mab798"]/div[1]/div[2]
        return toastMessage.getText();
    }

    public String getWrongUsernamedMessage()
    {
        WebDriverWait wait = new WebDriverWait(DriverFactory.driver,15);
        toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']/div[1]")));
        return toastMessage.getText();
    }

}
