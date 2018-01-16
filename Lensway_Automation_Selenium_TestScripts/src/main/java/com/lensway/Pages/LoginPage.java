package com.lensway.Pages;

import com.lensway.baseconfiguration.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase  {


    //Page Factory

    @FindBy(xpath="//span[text()='Logga in']")
    private WebElement signin;

    @FindBy(xpath = "//input[@name='j_username']")
    private WebElement username;

    @FindBy(xpath= "//input[@name='j_password]")
    private WebElement password;

    @FindBy(xpath= "//input[@value='Logga in]")
    private WebElement login;

    @FindBy(xpath = "//path[contains@class='stVCJ99]")
    private WebElement lenswayimage;

    @FindBy(xpath= "//input[@value='Återställ lösenord")
    private WebElement forgotpwd;

    @FindBy(partialLinkText= "Registrera dig här")
    private WebElement regbtn;


//Initializing the page objects - How to intialize the elements with the help of page factory - constructor of this class

    public LoginPage(WebDriver driver)

    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



    public HomePage login(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        login.click();

        return new HomePage();
    }


}



