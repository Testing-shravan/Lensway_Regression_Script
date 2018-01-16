package com.lensway.baseconfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;



    // Get data from properties file
    public TestBase(){

        try{

            Properties prop=new Properties();
            FileInputStream input=new FileInputStream("C:\\Users\\sarvij\\IdeaProjects\\Lensway_Automation_Regression_Scripts\\src\\main\\java\\com\\lensway\\configuration\\config.properties");
            prop.load(input);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    // Browser initiation
    public  void Browserinit(){

        String browserName=prop

        if (browserName.equalsIgnoreCase("firefox"))
        {
            driver= new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        else if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","H:\\Softwares\\driver\\chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        else if (browserName.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver","H:\\Softwares\\driver\\chromedriver.exe");
            driver= new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    //Explicit Wait Method
    public void explicitwait(int waitvalue,WebElement webelementval){
        WebDriverWait wt= new WebDriverWait(driver,waitvalue);
        wt.until(ExpectedConditions.visibilityOf(webelementval));
    }

    //Capture Screenshots

}



