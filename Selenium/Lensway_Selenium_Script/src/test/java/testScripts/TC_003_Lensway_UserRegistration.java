package testScripts;

import lenswayPages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TC_003_Lensway_UserRegistration extends TestBase {

    HomePage homePage;


    @BeforeClass
    public void setUp()
    {

        init();

    }

    @Test

    public void userRegistration()
    {
        log.info("#######################Starting test to verify User registration details#####################################");
        homePage=new HomePage(driver);
        homePage.registration_Lensway();
        homePage.registrationSuccess();
        Assert.assertEquals(false,homePage.registrationSuccess());
        log.info("#######################Finished test to User registration details#####################################");

    }

    @AfterClass

    public void endTest()
    {
        driver.close();

    }

}

