package com.lensway.testbase;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.lensway.util.webdriver.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {

   public WebDriver driver;
    public Properties prop;

public TestBase() throws IOException {


    try {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("C:\\Users\\sarvij\\IdeaProjects\\regression_script\\src\\main\\java\\com\\" +
                "lensway\\configuration\\config.properties");
        prop.load(input);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void selectBrowser() {

      String browserName=prop.getProperty("browser");

        if (browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "H:\\Softwares\\driver\\geckodriver.exe");
            driver= new FirefoxDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        else if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "H:\\Softwares\\driver\\chromedriver.exe");
            driver =new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        else if (browserName.equals("IE")){
            System.setProperty("webdriver.ie.driver", "H:\\Softwares\\driver\\IEDriverServer.exe");
            driver= new InternetExplorerDriver();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(WebDriverUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(WebDriverUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

        //URL is launched from property
        driver.get(prop.getProperty("url"));
    }

}
