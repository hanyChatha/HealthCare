package utils;

import base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver driver;
    public static Properties properties;

    public static WebDriver getDriver(){
        properties = new Properties();

        try {
            FileInputStream fs = new FileInputStream("src/main/java/config/data.properties");
            properties.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        BasePage.initPages();
        return driver;

    }

    public static void closeDriver()
    {
        driver.quit();
    }



}
