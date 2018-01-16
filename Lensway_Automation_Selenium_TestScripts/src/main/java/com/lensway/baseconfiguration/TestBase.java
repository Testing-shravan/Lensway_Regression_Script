package com.lensway.baseconfiguration;

import com.lensway.utillities.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

public static WebDriver driver;
public static Properties prop;


public TestBase(){

    try{

        Properties prop=new Properties();
        FileInputStream ip=new FileInputStream("C:\\Users\\sarvij\\IdeaProjects\\Lensway_Automation_Selenium_TestScripts\\src\\main\\java\\com\\lensway\\configuration\\config.properties");
        prop.load(ip);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}

public static void initialization(String browserNameValue, String url)
{
    String browserName=prop.getProperty("browser");

    if (browserNameValue.equals("chrome")){

        System.setProperty("webdriver.chrome.driver", "H:\\Softwares\\driver\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    else if (browserNameValue.equals("firefox")){

        System.setProperty("webdriver.gecko.driver", "H:\\Softwares\\driver\\geckodriver.exe");
        driver=new FirefoxDriver();
    }

    else if (browserNameValue.equals("InternetExplorer")){

        System.setProperty("webdriver.IE.driver", "H:\\Softwares\\driver\\IEDriverServer.exe");
        driver=new InternetExplorerDriver();
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_Timeout, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait,TimeUnit.SECONDS);

    driver.get(prop.getProperty("url"));

}

}
