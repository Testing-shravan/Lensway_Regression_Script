package com.lensway.testscripts;

import com.lensway.baseconfiguration.TestBase;
import com.lensway.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserLogin extends TestBase {

    public LoginPage loginPage; // defined in the class level so that throughout project i can use this object




    public void setUp()

    {


        Browserinit("browserName","url");
        //loginPage=new LoginPage(); // have to create the object of loging page class
    }

    @Test
    public void loginTest()
    {
        loginPage=new LoginPage(driver);
        loginPage.login("uname","pwd");


    }



    // public void tearDown()
    //{
    //   driver.quit();
    //}


}


