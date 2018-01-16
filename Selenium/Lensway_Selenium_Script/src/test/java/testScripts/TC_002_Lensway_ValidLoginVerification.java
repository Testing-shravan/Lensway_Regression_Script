package testScripts;

import lenswayPages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.concurrent.TimeUnit;

public class TC_002_Lensway_ValidLoginVerification extends TestBase {


    HomePage homePage;

    @BeforeTest

    public void setuUp()
    {

       init();

    }

    @Test

    public void loginValidation()  {
        log.info("#######################Starting test to verify login details#####################################");
        homePage=new HomePage(driver);

        homePage.login_Lensway("Testuat@lensway.com", "Test@1231");

        log.info("#######################Finished test to verify login details#####################################");

    }

    @AfterClass

    public void endTest()
    {
        driver.close();

    }

}


