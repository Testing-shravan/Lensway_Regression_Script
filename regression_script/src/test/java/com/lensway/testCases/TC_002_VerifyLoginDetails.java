package com.lensway.testCases;


import com.lensway.testbase.TestBase;
import com.lensway.uiPages.HomePage;
import com.lensway.uiPages.LoginPage;
import org.testng.annotations.*;

import java.io.IOException;



public class TC_002_VerifyLoginDetails extends TestBase {


    LoginPage loginPage;

    public TC_002_VerifyLoginDetails() throws IOException {

        super();
    }


    @BeforeMethod
    public void setUp()  {

        selectBrowser();

    }

    @Test

    public void loginTest() throws IOException {

         loginPage.login_Lensway(prop.getProperty("username"),prop.getProperty("password"));


    }

    @AfterMethod

    public void endTest()
    {
        driver.close();
    }

    }


