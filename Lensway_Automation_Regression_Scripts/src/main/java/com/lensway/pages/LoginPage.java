package com.lensway.pages;

import com.lensway.baseconfiguration.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


    public class LoginPage extends TestBase {


        //Page Factory

        @FindBy(xpath = "//input[@name='j_username")
        WebElement username;

        @FindBy(xpath= "//input[@name='j_password]")
        WebElement password;

        @FindBy(xpath= "//input[@value='Logga in]")
        WebElement login;

        @FindBy(xpath = "//path[contains@class='stVCJ99]")
        WebElement lenswayimage;

        @FindBy(xpath= "//input[@value='Återställ lösenord")
        WebElement forgotpwd;

        @FindBy(partialLinkText= "Registrera dig här")
        WebElement regbtn;


//Initializing the page objects - How to intialize the elements with the help of page factory - constructor of this class

        public LoginPage(WebDriver driver)
        {
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

        public void login(String uname, String pwd)
        {
            username.sendKeys(uname);
            password.sendKeys(pwd);
            login.click();
        }

    }






